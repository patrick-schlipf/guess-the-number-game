package udemy.academy.learnprogramming;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import udemy.academy.learnprogramming.config.GameConfiguration;


@Slf4j
public class Main {

    public static void main(String[] args) {
        log.info("Guess the Number GameImpl");

        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(GameConfiguration.class);

        ctx.close();
    }
}
