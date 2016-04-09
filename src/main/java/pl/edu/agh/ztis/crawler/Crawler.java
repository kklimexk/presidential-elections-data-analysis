package pl.edu.agh.ztis.crawler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.edu.agh.ztis.db.services.UserService;
import pl.edu.agh.ztis.twitter.search.TweetFinder;
import twitter4j.Status;
import twitter4j.User;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Component
public class Crawler {

    private final String[] candidates = {"HillaryClinton", "SenSanders",
            "realDonaldTrump", "tedcruz", "JohnKasich", "marcorubio"};

    @Autowired
    private TweetFinder tweetFinder;

    @Autowired
    private UserService userService;

    public Crawler() {
    }

    public void run() {
        for (String candidate : candidates) {
            for (int i = 1; i < 10; ++i) {
                CompletableFuture<List<Status>> statusesF = tweetFinder.searchAndSaveTweetsForUserAsync(candidate, i, Optional.empty());
                statusesF.thenAccept(statuses -> statuses.forEach(status -> {
                    User u = status.getUser();
                    userService.save(new pl.edu.agh.ztis.db.models.User(new Date(),
                            u.getId(),
                            u.getCreatedAt(),
                            u.getName(),
                            u.getScreenName(),
                            u.getStatusesCount(),
                            u.getFollowersCount(),
                            u.getLang(),
                            u.getLocation()));
                }));
            }
        }
    }
}
