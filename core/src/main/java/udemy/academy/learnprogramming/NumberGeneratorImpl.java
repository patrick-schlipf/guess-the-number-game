package udemy.academy.learnprogramming;

import org.springframework.stereotype.Component;

import java.util.Random;


@Component
public class NumberGeneratorImpl implements NumberGenerator {

    private final Random random = new Random();

    private int maxNumber = 100;


    @Override
    public int next() {
        return this.random.nextInt(this.maxNumber);
    }

    @Override
    public int getMaxNumber() {
        return this.maxNumber;
    }
}
