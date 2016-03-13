package pl.edu.agh.ztis.crawler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.edu.agh.ztis.db.models.Tweet;
import pl.edu.agh.ztis.db.services.TweetService;
import pl.edu.agh.ztis.twitter.search.TweetFinder;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Component
public class Crawler {

    private final String[] candidates = { "HillaryClinton", "SenSanders",
            "realDonaldTrump", "tedcruz", "JohnKasich", "marcorubio" };

    @Autowired
    private TweetFinder tweetFinder;

    @Autowired
    private TweetService tweetService;

    public Crawler() {
    }

    public void run() {
        for (String candidate : candidates) {
            for (int i = 1; i < 10; ++i) {
                CompletableFuture<List<Tweet>> tweetsF = tweetFinder.searchTweetsForUserAsync(candidate, i, Optional.empty());
                tweetsF.thenAccept(tweets -> tweetService.save(tweets));
            }
        }
    }
}
