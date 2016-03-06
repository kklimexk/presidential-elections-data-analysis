package pl.edu.agh.ztis.db.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.ztis.db.models.Tweet;
import pl.edu.agh.ztis.db.repositories.TweetRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TweetService {

    @Autowired
    private TweetRepository tweetRepository;

    public void save(Tweet tweet) {
        if (!findById(tweet.getTweetId()).isPresent()) tweetRepository.save(tweet);
    }

    public void save(List<Tweet> tweets) {
        List<Tweet> filteredTweets = tweets.stream()
                .filter(tweet -> !findById(tweet.getTweetId()).isPresent())
                .collect(Collectors.toList());
        tweetRepository.save(filteredTweets);
    }

    public Optional<Tweet> findById(Long id) {
        return Optional.ofNullable(tweetRepository.findByTweetId(id));
    }

    public List<Tweet> findAll() {
        return tweetRepository.findAll();
    }
}
