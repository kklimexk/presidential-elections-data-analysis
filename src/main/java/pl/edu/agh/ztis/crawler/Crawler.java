package pl.edu.agh.ztis.crawler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.edu.agh.ztis.twitter.search.TweetFinder;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Component
public class Crawler {

    private final String[] candidates = {"HillaryClinton", "SenSanders",
            "realDonaldTrump", "tedcruz", "JohnKasich", "marcorubio"};

    @Autowired
    private TweetFinder tweetFinder;

    public Crawler() {
    }

    public void run() {
        for (String candidate : candidates) {
            CompletableFuture<pl.edu.agh.ztis.db.models.User> userF = tweetFinder.searchAndSaveUserAsync(candidate);
            for (int i = 1; i < 10; ++i) {
                final int finalI = i;
                userF.thenAccept(user -> {
                    //tweetFinder.searchAndSaveFollowersForUser(user);
                    tweetFinder.searchAndSaveTweetsForUserAsync(candidate, finalI, Optional.empty());
                });
            }
        }
    }
}
