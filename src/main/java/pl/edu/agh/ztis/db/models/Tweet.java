package pl.edu.agh.ztis.db.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import twitter4j.GeoLocation;

import java.util.Date;
import java.util.List;

@Document(collection = "tweets")
public class Tweet {

    private Date crawledDate;
    @Id
    private Long tweetId;
    private Date createdAt;
    private String text;
    private Long inReplyToStatusId;
    private Long inReplyToUserId;
    private String source;
    private Boolean isRetweet;
    private GeoLocation geoLocation;
    private Integer retweetCount;
    private Integer favouriteCount;
    private List<String> hashtags;
    private Long userId;

    public Tweet() {
    }

    public Tweet(Date crawledDate, Long tweetId, Date createdAt, String text, Long inReplyToStatusId, Long inReplyToUserId, String source, Boolean isRetweet, GeoLocation geoLocation, Integer retweetCount, Integer favouriteCount, List<String> hashtags, Long userId) {
        this.crawledDate = crawledDate;
        this.tweetId = tweetId;
        this.createdAt = createdAt;
        this.text = text;
        this.inReplyToStatusId = inReplyToStatusId;
        this.inReplyToUserId = inReplyToUserId;
        this.source = source;
        this.isRetweet = isRetweet;
        this.geoLocation = geoLocation;
        this.retweetCount = retweetCount;
        this.favouriteCount = favouriteCount;
        this.hashtags = hashtags;
        this.userId = userId;
    }

    public Date getCrawledDate() {
        return crawledDate;
    }

    public void setCrawledDate(Date crawledDate) {
        this.crawledDate = crawledDate;
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

    public Long getInReplyToStatusId() {
        return inReplyToStatusId;
    }

    public void setInReplyToStatusId(Long inReplyToStatusId) {
        this.inReplyToStatusId = inReplyToStatusId;
    }

    public Long getInReplyToUserId() {
        return inReplyToUserId;
    }

    public void setInReplyToUserId(Long inReplyToUserId) {
        this.inReplyToUserId = inReplyToUserId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Boolean getRetweet() {
        return isRetweet;
    }

    public void setRetweet(Boolean retweet) {
        isRetweet = retweet;
    }

    public GeoLocation getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(GeoLocation geoLocation) {
        this.geoLocation = geoLocation;
    }

    public Integer getRetweetCount() {
        return retweetCount;
    }

    public void setRetweetCount(Integer retweetCount) {
        this.retweetCount = retweetCount;
    }

    public Integer getFavouriteCount() {
        return favouriteCount;
    }

    public void setFavouriteCount(Integer favouriteCount) {
        this.favouriteCount = favouriteCount;
    }

    public List<String> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<String> hashtags) {
        this.hashtags = hashtags;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                ", crawledDate=" + crawledDate +
                ", tweetId=" + tweetId +
                ", createdAt=" + createdAt +
                ", text='" + text + '\'' +
                ", inReplyToStatusId=" + inReplyToStatusId +
                ", inReplyToUserId=" + inReplyToUserId +
                ", source='" + source + '\'' +
                ", isRetweet=" + isRetweet +
                ", geoLocation=" + geoLocation +
                ", retweetCount=" + retweetCount +
                ", favouriteCount=" + favouriteCount +
                ", hashtags=" + hashtags +
                ", userId=" + userId +
                '}';
    }
}
