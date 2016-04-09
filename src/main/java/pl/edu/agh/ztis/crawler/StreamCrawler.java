package pl.edu.agh.ztis.crawler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.agh.ztis.twitter.streaming.TweetStreamFinder;

@Component
public class StreamCrawler {

    @Autowired
    private TweetStreamFinder tweetStreamFinder;

    private final String KEYWORDS[] = { "Trump", "clinton", "usaelections",
            "usa elections", "usa election", "election2016", "election", "MakeAmericaGreatAgain" };

    public StreamCrawler() {
    }

    public void run() {
        tweetStreamFinder.getTweetStreamForKeywords(KEYWORDS);
    }
}
