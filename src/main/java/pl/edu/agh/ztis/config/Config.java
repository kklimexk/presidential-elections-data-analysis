package pl.edu.agh.ztis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import pl.edu.agh.ztis.crawler.Crawler;
import pl.edu.agh.ztis.db.MongoDbConfig;
import pl.edu.agh.ztis.twitter.TwitterConfig;

@Configuration
@Import({MongoDbConfig.class, TwitterConfig.class})
public class Config {
    @Bean
    public Crawler crawler() {
        return new Crawler();
    }
}