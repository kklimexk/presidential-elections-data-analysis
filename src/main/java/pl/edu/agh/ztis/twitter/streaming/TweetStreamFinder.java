package pl.edu.agh.ztis.twitter.streaming;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.edu.agh.ztis.db.models.*;
import pl.edu.agh.ztis.db.services.TweetService;

import pl.edu.agh.ztis.db.services.UserService;
import twitter4j.*;
import twitter4j.User;

import java.util.ArrayList;
import java.util.Date;

@Component
public class TweetStreamFinder {

    @Autowired
    private TweetService tweetService;
    @Autowired
    private UserService userService;

    public void getTweetStreamForKeywords(String... keywords) {
        TwitterStream twitterStream = new TwitterStreamFactory().getInstance();

        StatusListener statusListener = new StatusListener() {

            @Override
            public void onStatus(Status status) {
                User u = status.getUser();
                userService.save(new pl.edu.agh.ztis.db.models.User(new Date(),
                        u.getId(),
                        u.getCreatedAt(),
                        u.getName(),
                        u.getScreenName(),
                        u.getStatusesCount(),
                        u.getFollowersCount(),
                        u.getLang(),
                        u.getLocation(),
                        new ArrayList<>()));

                tweetService.save(new Tweet(new Date(),
                        status.getId(),
                        status.getCreatedAt(),
                        status.getText(),
                        status.getInReplyToStatusId(),
                        status.getInReplyToUserId(),
                        status.getSource(),
                        status.isRetweet(),
                        status.getGeoLocation(),
                        status.getRetweetCount(),
                        status.getFavoriteCount(),
                        TweetStreamUtils.hashTagEntitiesToStrings(status.getHashtagEntities()),
                        u.getId()));
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
