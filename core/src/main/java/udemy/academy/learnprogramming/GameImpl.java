//*****************************************************************************
//*
//* FILE NAME:  GameImpl.java
//*
//* IBM Confidential
//*
//*  OCO Source Materials
//*
//*  5698-SA4
//*
//*  © Copyright IBM Corp. 2019
//*
//*   The source code for this program is not published or otherwise
//*   divested of its trade secrets, irrespective of what has been
//*   deposited with the U.S. Copyright Office.
//*
//*****************************************************************************
//*
//* CLASSES:
//*            GameImpl   (externally documented: no )
//*
//* CHANGE HISTORY:
//*
//*   Change Date     UserID   Description
//*   -----  -------- -------- ------------------------------------------------
//*   y0001  05072019 psch     Initial Version
//*
//*****************************************************************************
package udemy.academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Component
public class GameImpl implements Game {

    private final Logger log = LoggerFactory.getLogger(Game.class);

    private NumberGenerator numberGenerator;
    private int guessCount = 10;
    private int number;
    private int guess;
    private int smallest;
    private int biggest;
    private int remainingGuesses;
    private boolean validNumberRange = true;

    @PostConstruct
    @Override
    public void reset() {
        this.remainingGuesses = this.guessCount;
        this.guess = 0;
        this.smallest = 0;
        this.biggest = this.numberGenerator.getMaxNumber();
        this.number = this.numberGenerator.next();

        log.debug("The number is {}", this.number);
    }

    @PreDestroy
    public void preDestroy() {
        log.debug("In-Game preDestroy()");
    }

    @Override
    public int getNumber() {
        return this.number;
    }

    @Override
    public int getGuess() {
        return this.guess;
    }

    @Override
    public void setGuess(int guess) {
        this.guess = guess;
    }

    @Override
    public int getSmallest() {
        return this.smallest;
    }

    @Override
    public int getBiggest() {
        return this.biggest;
    }

    @Override
    public int getRemainingGuesses() {
        return this.remainingGuesses;
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
    public boolean isValidNumberRange() {
        return this.validNumberRange;
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


    @Autowired
    public void setNumberGenerator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

}
