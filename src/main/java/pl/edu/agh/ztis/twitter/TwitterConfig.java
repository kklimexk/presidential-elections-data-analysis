package pl.edu.agh.ztis.twitter;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"pl.edu.agh.ztis.twitter.search", "pl.edu.agh.ztis.twitter.streaming"})
public class TwitterConfig {
}
