package pl.edu.agh.ztis.crawler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.edu.agh.ztis.twitter.search.TweetFinder;
import java.util.Optional;

@Component
public class Crawler {

    private final String[] candidates = { "HillaryClinton", "SenSanders",
            "realDonaldTrump", "tedcruz", "JohnKasich", "marcorubio" };

    @Autowired
    private TweetFinder tweetFinder;

    public Crawler() {
    }

    public void run() {
        for (String candidate : candidates) {
            for (int i = 1; i < 10; ++i) {
                tweetFinder.searchTweetsForUserAsync(candidate, i, Optional.empty());
            }
        }
    }
}
