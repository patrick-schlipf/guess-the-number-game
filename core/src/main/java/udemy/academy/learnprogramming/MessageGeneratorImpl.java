package udemy.academy.learnprogramming;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
@Slf4j
public class MessageGeneratorImpl implements MessageGenerator {

    private final Game game;


    @Autowired
    public MessageGeneratorImpl(Game game) {
        this.game = game;
    }

    @PostConstruct
    public void init() {
        log.debug("In MessageGenerator postConstruct()");
        log.debug("Game value: {}", this.game);
    }

    @Override
    public String getMainMessage() {
        return String.format(
                "Number is between %d and %d. Can you guess it?",
                this.game.getSmallest(),
                this.game.getBiggest()
        );
    }

    @Override
    public String getResultMessage() {
        if (this.game.isGameWon())
            return "You guessed it. The number was " + this.game.getNumber();
        else if (this.game.isGameLost())
            return "You lost. The number was " + this.game.getNumber();
        else if (!this.game.isValidNumberRange())
            return "Invalid number range.";
        else if (this.game.getRemainingGuesses() == this.game.getGuessCount())
            return "What is your first guess?";

        String direction = "Lower";
        if (this.game.getGuess() < this.game.getNumber())
            direction = "Higher";

        return String.format(
                "%s! You have %d guesses left.",
                direction,
                this.game.getRemainingGuesses()
        );
    }
}
