package pl.edu.agh.ztis.twitter.streaming;

import twitter4j.HashtagEntity;

import java.util.ArrayList;
import java.util.List;

public class TweetStreamUtils {
    public static List<String> hashTagEntitiesToStrings(HashtagEntity[] entities) {
        List<String> convertedEntities = new ArrayList<>();
        for (HashtagEntity entity : entities) {
            convertedEntities.add(entity.getText());
        }
        return convertedEntities;
    }
}
