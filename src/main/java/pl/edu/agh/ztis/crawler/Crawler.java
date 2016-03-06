package pl.edu.agh.ztis.crawler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.agh.ztis.db.models.Tweet;
import pl.edu.agh.ztis.db.services.TweetService;
import pl.edu.agh.ztis.twitter.TweetFinder;
import twitter4j.Status;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class Crawler {

    @Autowired
    private TweetFinder tweetFinder;

    @Autowired
    private TweetService tweetService;

    public Crawler() {
    }

    public void run() {
        for (int i = 1; i < 10; ++i) {
            List<Status> tweets = tweetFinder.searchTweetsForUser("realDonaldTrump", i, Optional.empty());
            tweetService.save(tweets.stream()
                    .map(status -> new Tweet(status.getId(), status.getText()))
                    .collect(Collectors.toList()));
        }
    }
}
