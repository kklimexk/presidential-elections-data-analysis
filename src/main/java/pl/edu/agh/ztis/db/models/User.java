package pl.edu.agh.ztis.db.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "users")
public class User {

    private Date crawledDate;
    @Id
    private Long userId;
    private Date createdAt;
    private String name;
    private String screenName;
    private Integer numOfTweets;
    private Integer numOfFollowers;
    private String language;
    private String location;
    private List<Long> followersIds;

    public User() {
    }

    public User(Date crawledDate, Long userId, Date createdAt, String name, String screenName, Integer numOfTweets, Integer numOfFollowers, String language, String location, List<Long> followersIds) {
        this.crawledDate = crawledDate;
        this.userId = userId;
        this.createdAt = createdAt;
        this.name = name;
        this.screenName = screenName;
        this.numOfTweets = numOfTweets;
        this.numOfFollowers = numOfFollowers;
        this.language = language;
        this.location = location;
        this.followersIds = followersIds;
    }

    public Date getCrawledDate() {
        return crawledDate;
    }

    public void setCrawledDate(Date crawledDate) {
        this.crawledDate = crawledDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public Integer getNumOfTweets() {
        return numOfTweets;
    }

    public void setNumOfTweets(Integer numOfTweets) {
        this.numOfTweets = numOfTweets;
    }

    public Integer getNumOfFollowers() {
        return numOfFollowers;
    }

    public void setNumOfFollowers(Integer numOfFollowers) {
        this.numOfFollowers = numOfFollowers;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Long> getFollowersIds() {
        return followersIds;
    }

    public void setFollowersIds(List<Long> followersIds) {
        this.followersIds = followersIds;
    }

    @Override
    public String toString() {
        return "User{" +
                ", crawledDate=" + crawledDate +
                ", userId=" + userId +
                ", createdAt=" + createdAt +
                ", name='" + name + '\'' +
                ", screenName='" + screenName + '\'' +
                ", numOfTweets=" + numOfTweets +
                ", numOfFollowers=" + numOfFollowers +
                ", language='" + language + '\'' +
                ", location='" + location + '\'' +
                ", followersIds=" + followersIds +
                '}';
    }
}
