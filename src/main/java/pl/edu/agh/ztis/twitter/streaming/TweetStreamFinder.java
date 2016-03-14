package pl.edu.agh.ztis.twitter.streaming;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.edu.agh.ztis.db.models.Tweet;
import pl.edu.agh.ztis.db.services.TweetService;

import twitter4j.*;

@Component
public class TweetStreamFinder {

    @Autowired
    private TweetService tweetService;

    public void getTweetStreamForKeywords(String... keywords) {
        TwitterStream twitterStream = new TwitterStreamFactory().getInstance();

        StatusListener statusListener = new StatusListener() {

            @Override
            public void onStatus(Status status) {
                tweetService.save(new Tweet(status.getId(), status.getCreatedAt(), status.getText()));
            }

            @Override
            public void onDeletionNotice(StatusDeletionNotice sdn) {
                //System.out.println("Not supported yet!");
            }

            @Override
            public void onTrackLimitationNotice(int i) {
                //System.out.println("Not supported yet!");
            }

            @Override
            public void onScrubGeo(long l, long l1) {
                //System.out.println("Not supported yet!");
            }

            @Override
            public void onStallWarning(StallWarning sw) {
                //System.out.println("Not supported yet!");
            }

            @Override
            public void onException(Exception ex) {
                //System.out.println("Not supported yet!");
            }
        };

        FilterQuery fq = new FilterQuery();

        fq.track(keywords);

        twitterStream.addListener(statusListener);
        twitterStream.filter(fq);
    }
}
