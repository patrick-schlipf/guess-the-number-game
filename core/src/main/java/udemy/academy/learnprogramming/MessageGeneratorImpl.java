//*****************************************************************************
//*
//* FILE NAME:  MessageGeneratorImpl.java
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
//*            MessageGeneratorImpl   (externally documented: no )
//*
//* CHANGE HISTORY:
//*
//*   Change Date     UserID   Description
//*   -----  -------- -------- ------------------------------------------------
//*   y0001  12072019 psch     Initial Version
//*
//*****************************************************************************
package udemy.academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class MessageGeneratorImpl implements MessageGenerator {

    private final Logger log = LoggerFactory.getLogger(MessageGenerator.class);

    private Game game;
    private int guessCount = 10;

    @PostConstruct
    public void init() {
        log.debug("In MessageGenerator postConstruct()");
        log.debug("Game value: {}", this.game);
    }


    @Override
    public String getMainMessage() {
        return "Method call 'getMainMessage()'";
    }

    @Override
    public String getResultMessage() {
        return "Method call 'getResultMessage()'";
    }


    @Autowired
    public void setGame(Game game) {
        this.game = game;
    }

}
