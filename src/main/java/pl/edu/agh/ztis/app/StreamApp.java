package pl.edu.agh.ztis.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import pl.edu.agh.ztis.config.Config;
import pl.edu.agh.ztis.twitter.streaming.TweetStreamFinder;

@SpringBootApplication
@Import({Config.class})
public class StreamApp implements CommandLineRunner {

    private final String KEYWORDS[] = { "Trump", "clinton", "usaelections",
            "usa elections", "usa election", "election2016", "election", "MakeAmericaGreatAgain" };

    @Autowired
    private TweetStreamFinder tweetStreamFinder;

    @Override
    public void run(String... strings) throws Exception {
        tweetStreamFinder.getTweetStreamForKeywords(KEYWORDS);
    }

    public static void main(String[] args) {
        SpringApplication.run(StreamApp.class, args);
    }
}
