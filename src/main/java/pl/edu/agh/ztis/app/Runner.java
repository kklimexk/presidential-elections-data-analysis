package pl.edu.agh.ztis.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import pl.edu.agh.ztis.config.Config;
import pl.edu.agh.ztis.crawler.Crawler;
import pl.edu.agh.ztis.crawler.StreamCrawler;

@Component
@Import({Config.class})
public class Runner implements CommandLineRunner {

    @Autowired
    private Crawler crawler;

    @Autowired
    private StreamCrawler streamCrawler;

    @Override
    public void run(String... args) throws Exception {
        if (args.length == 1 && "stream".equals(args[0])) {
            streamCrawler.run();
        } else {
            crawler.run();
        }
    }
}
