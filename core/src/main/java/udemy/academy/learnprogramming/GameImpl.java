package udemy.academy.learnprogramming;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Component
@Slf4j
@Getter
public class GameImpl implements Game {

    @Getter(AccessLevel.NONE)
    private final NumberGenerator numberGenerator;

    private final int guessCount;
    private int number;
    private int smallest;
    private int biggest;
    private int remainingGuesses;
    private boolean validNumberRange = true;

    @Setter
    private int guess;


    @Autowired
    public GameImpl(NumberGenerator numberGenerator, @GuessCount int guessCount) {
        this.numberGenerator = numberGenerator;
        this.guessCount = guessCount;
    }

    @PostConstruct
    @Override
    public void reset() {
        this.remainingGuesses = this.guessCount;
        this.guess = this.numberGenerator.getMinNumber();
        this.smallest = this.numberGenerator.getMinNumber();
        this.biggest = this.numberGenerator.getMaxNumber();
        this.number = this.numberGenerator.next();

        log.debug("The number is {}", this.number);
    }

    @PreDestroy
    public void preDestroy() {
        log.debug("In-Game preDestroy()");
    }

    @Override
    public void check() {
        this.checkValidNumberRange();

        if (this.validNumberRange) {
            if (this.guess > this.number) {
                this.biggest = this.guess - 1;
            }

            if (this.guess < this.number) {
                this.smallest = this.guess + 1;
            }
        }

        this.remainingGuesses--;
    }

    @Override
    public boolean isGameWon() {
        return (this.guess == this.number);
    }

    @Override
    public boolean isGameLost() {
        return (!this.isGameWon() && this.remainingGuesses <= 0);
    }


    private void checkValidNumberRange() {
        this.validNumberRange = (this.guess >= this.smallest) && (this.guess <= this.biggest);
    }
}
