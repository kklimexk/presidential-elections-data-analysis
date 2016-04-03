package pl.edu.agh.ztis.twitter.search;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import pl.edu.agh.ztis.db.models.Tweet;
import pl.edu.agh.ztis.twitter.streaming.TweetStreamUtils;
import twitter4j.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Component
public class TweetFinder {

    public List<Tweet> searchTweetsForUser(String user, Integer page, Optional<Integer> count) {
        Twitter twitter = TwitterFactory.getSingleton();
        Paging paging = count.map(c -> new Paging(page, c)).orElse(new Paging(page));
        List<Status> statuses = null;
        try {
            statuses = twitter.getUserTimeline(user, paging);
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        return statuses
                .stream().map(s ->
                        new Tweet(new Date(),
                                s.getId(),
                                s.getCreatedAt(),
                                s.getText(),
                                s.getInReplyToStatusId(),
                                s.getInReplyToUserId(),
                                s.getSource(),
                                s.isRetweet(),
                                s.getGeoLocation(),
                                s.getRetweetCount(),
                                s.getFavoriteCount(),
                                TweetStreamUtils.hashTagEntitiesToStrings(s.getHashtagEntities()),
                                s.getUser().getId())
                ).collect(Collectors.toList());
    }

    @Async
    public CompletableFuture<List<Tweet>> searchTweetsForUserAsync(String user, Integer page, Optional<Integer> count) {
        List<Tweet> tweets = searchTweetsForUser(user, page, count);
        return CompletableFuture.completedFuture(tweets);
    }

}
