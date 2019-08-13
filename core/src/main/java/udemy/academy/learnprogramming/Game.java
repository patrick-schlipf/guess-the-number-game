//*****************************************************************************
//*
//* FILE NAME:  Game.java
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
//*            Game   (externally documented: no )
//*
//* CHANGE HISTORY:
//*
//*   Change Date     UserID   Description
//*   -----  -------- -------- ------------------------------------------------
//*   y0001  12072019 psch     Initial Version
//*
//*****************************************************************************
package udemy.academy.learnprogramming;


public interface Game {

    int getNumber();

    int getGuess();

    void setGuess(int guess);

    int getSmallest();

    int getBiggest();

    int getRemainingGuesses();

    void reset();

    void check();

    boolean isValidNumberRange();

    boolean isGameWon();

    boolean isGameLost();

}
