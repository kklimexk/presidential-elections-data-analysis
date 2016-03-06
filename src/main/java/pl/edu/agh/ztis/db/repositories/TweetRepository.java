package pl.edu.agh.ztis.db.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.edu.agh.ztis.db.models.Tweet;

public interface TweetRepository extends MongoRepository<Tweet, String> {
    Tweet findByTweetId(Long tweetId);
}
