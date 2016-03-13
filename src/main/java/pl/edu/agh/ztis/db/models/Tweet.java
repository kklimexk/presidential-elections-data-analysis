package pl.edu.agh.ztis.db.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "tweets")
public class Tweet {

    @Id
    private String id;

    private Long tweetId;
    private Date createdAt;
    private String text;

    public Tweet() {
    }

    public Tweet(Long tweetId, Date createdAt, String text) {
        this.tweetId = tweetId;
        this.createdAt = createdAt;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getTweetId() {
        return tweetId;
    }

    public void setTweetId(Long tweetId) {
        this.tweetId = tweetId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "tweetId=" + tweetId +
                ", createdAt=" + createdAt +
                ", text='" + text + '\'' +
                '}';
    }
}
