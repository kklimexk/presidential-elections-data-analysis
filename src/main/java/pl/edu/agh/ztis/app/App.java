package pl.edu.agh.ztis.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import pl.edu.agh.ztis.config.Config;
import pl.edu.agh.ztis.crawler.Crawler;

@SpringBootApplication
@Import({Config.class})
public class App implements CommandLineRunner {

    @Autowired
    private Crawler crawler;

    @Override
    public void run(String... strings) throws Exception {
        crawler.run();
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
