package pl.edu.agh.ztis.twitter;

import org.springframework.stereotype.Component;
import twitter4j.*;

import java.util.List;
import java.util.Optional;

@Component
public class TweetFinder {
    public List<Status> searchTweetsForUser(String user, Integer page, Optional<Integer> count) {
        Twitter twitter = TwitterFactory.getSingleton();
        Paging paging = count.map(c -> new Paging(page, c)).orElse(new Paging(page));
        List<Status> statuses = null;
        try {
            statuses = twitter.getUserTimeline(user, paging);
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        return statuses;
    }
}
