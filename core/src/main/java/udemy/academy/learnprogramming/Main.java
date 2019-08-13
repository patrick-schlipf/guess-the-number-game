package udemy.academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = "udemy.academy.learnprogramming")
public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Guess the Number GameImpl");

        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfiguration.class);

        MessageGenerator messageGenerator = ctx.getBean(MessageGenerator.class);

        log.debug(messageGenerator.getMainMessage());
        log.debug(messageGenerator.getResultMessage());

        ctx.close();
    }
}
