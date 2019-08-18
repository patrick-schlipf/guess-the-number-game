package udemy.academy.learnprogramming;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;


@Component
@Slf4j
public class ConsoleNumberGuess {

    private final Game game;
    private final MessageGenerator messageGenerator;


    @Autowired
    public ConsoleNumberGuess(Game game, MessageGenerator messageGenerator) {
        this.game = game;
        this.messageGenerator = messageGenerator;
    }


    @EventListener(ContextRefreshedEvent.class)
    public void start() {
        log.info("Start() ---> Container ready for use.");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(this.messageGenerator.getMainMessage());
            System.out.println(this.messageGenerator.getResultMessage());

            int guess = scanner.nextInt();
            scanner.nextLine();
            this.game.setGuess(guess);
            this.game.check();

            if (this.game.isGameWon() || this.game.isGameLost()) {
                System.out.println(this.messageGenerator.getResultMessage());
                System.out.println("Play again? (y/n)");

                String playAgainString = scanner.nextLine().trim();
                if (!playAgainString.equalsIgnoreCase("y"))
                    break;

                this.game.reset();
            }
        }
    }
}
