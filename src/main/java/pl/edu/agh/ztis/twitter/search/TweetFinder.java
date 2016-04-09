package pl.edu.agh.ztis.twitter.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import pl.edu.agh.ztis.db.models.Tweet;
import pl.edu.agh.ztis.db.services.TweetService;
import pl.edu.agh.ztis.db.services.UserService;
import pl.edu.agh.ztis.twitter.streaming.TweetStreamUtils;
import twitter4j.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Component
public class TweetFinder {

    @Autowired
    private TweetService tweetService;

    public List<Status> searchAndSaveTweetsForUser(String user, Integer page, Optional<Integer> count) {
        Twitter twitter = TwitterFactory.getSingleton();
        Paging paging = count.map(c -> new Paging(page, c)).orElse(new Paging(page));
        List<Status> statuses = null;
        try {
            statuses = twitter.getUserTimeline(user, paging);
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        if (statuses != null) {
            statuses.forEach(status -> {
                User u = status.getUser();
                tweetService.save(new Tweet(new Date(),
                        status.getId(),
                        status.getCreatedAt(),
                        status.getText(),
                        status.getInReplyToStatusId(),
                        status.getInReplyToUserId(),
                        status.getSource(),
                        status.isRetweet(),
                        status.getGeoLocation(),
                        status.getRetweetCount(),
                        status.getFavoriteCount(),
                        TweetStreamUtils.hashTagEntitiesToStrings(status.getHashtagEntities()),
                        u.getId()));
            });
        }
        return statuses;
    }

    @Async
    public CompletableFuture<List<Status>> searchAndSaveTweetsForUserAsync(String user, Integer page, Optional<Integer> count) {
        List<Status> tweets = searchAndSaveTweetsForUser(user, page, count);
        return CompletableFuture.completedFuture(tweets);
    }

}
