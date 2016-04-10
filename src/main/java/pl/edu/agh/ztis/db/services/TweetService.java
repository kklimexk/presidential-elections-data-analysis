package pl.edu.agh.ztis.db.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.agh.ztis.db.models.Tweet;
import pl.edu.agh.ztis.db.repositories.TweetRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TweetService {

    @Autowired
    private TweetRepository tweetRepository;

    public void save(Tweet tweet) {
        tweetRepository.save(tweet);
    }

    public void save(List<Tweet> tweets) {
        tweetRepository.save(tweets);
    }

    public Optional<Tweet> findById(Long id) {
        return Optional.ofNullable(tweetRepository.findByTweetId(id));
    }

    public List<Tweet> findAll() {
        return tweetRepository.findAll();
    }
}
