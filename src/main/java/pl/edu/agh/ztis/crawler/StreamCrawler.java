package pl.edu.agh.ztis.crawler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.agh.ztis.twitter.streaming.TweetStreamFinder;

@Component
public class StreamCrawler {

    @Autowired
    private TweetStreamFinder tweetStreamFinder;

    private final String HASHTAGS[] = {
            "#Trump", "#Trump2016", "#TrumpTrain", "#realDonaldTrump", "#TeamTrump", "#DonaldTrump", "#MakeAmericaGreatAgain", "#NeverTrump",
            "#Clinton", "#TeamClinton", "#HillaryClinton", "#ClintonNotQualified",
            "#usaelections", "#USAelections", "#usaelections2016",
            "#Sanders", "#Bernie2016", "#Bernie", "#BernieSanders",
            "#TEDCRUZ2016", "#cruzcrew", "#TedCruz2016",
            "#JohnKasich", "#TeamKasich",
            "#MarcoRubio", "#TeamRubio", "#AlwaysRubio", "#OnlyMarco"
    };

    private final long[] USERS_TO_FOLLOW = {
            25073877, 23022687, 18020081, 1339835893, 29442313, 15745368
    };

    public StreamCrawler() {
    }

    public void run() {
        tweetStreamFinder.runTweetStreamForKeywords(HASHTAGS);
        tweetStreamFinder.runTweetStreamForUserToFollow(USERS_TO_FOLLOW);
    }
}
