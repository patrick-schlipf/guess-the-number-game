package udemy.academy.learnprogramming.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import udemy.academy.learnprogramming.GuessCount;
import udemy.academy.learnprogramming.MaxNumber;
import udemy.academy.learnprogramming.MinNumber;

@Configuration
@ComponentScan(basePackages = "udemy.academy.learnprogramming")
@PropertySource("classpath:config/game.properties")
public class GameConfiguration {

    @Value("${game.minNumber:5}")
    private int minNumber;

    @Value("${game.maxNumber:25}")
    private int maxNumber;

    @Value("${game.guessCount:5}")
    private int guessCount;

    @Bean
    @MinNumber
    public int minNumber() {
        return minNumber;
    }

    @Bean
    @MaxNumber
    public int maxNumber() {
        return maxNumber;
    }

    @Bean
    @GuessCount
    public int guessCount() {
        return guessCount;
    }
}
