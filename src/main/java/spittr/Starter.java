package spittr;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import spittr.data.SpittleRepository;
import spittr.data.model.Spittle;

import java.util.Date;

/**
 * @author Ilya Ivanov
 */
@SpringBootApplication
@EnableScheduling
public class Starter {
    public static void main(String[] args) {
        SpringApplication.run(Starter.class, args);
    }

    @Bean
    public CommandLineRunner init(SpittleRepository repository) {
        return args -> {
            repository.save(new Spittle("some message", new Date()));
        };
    }
}
