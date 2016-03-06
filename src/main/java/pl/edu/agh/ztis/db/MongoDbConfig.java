package pl.edu.agh.ztis.db;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories("pl.edu.agh.ztis.db.repositories")
@ComponentScan("pl.edu.agh.ztis.db.services")
public class MongoDbConfig {
}
