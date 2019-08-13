//*****************************************************************************
//*
//* FILE NAME:  AppConfiguration.java
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
//*            AppConfiguration   (externally documented: no )
//*
//* CHANGE HISTORY:
//*
//*   Change Date     UserID   Description
//*   -----  -------- -------- ------------------------------------------------
//*   y0001  12072019 psch     Initial Version
//*
//*****************************************************************************
package udemy.academy.learnprogramming;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfiguration {

    @Bean
    public MessageGenerator messageGenerator() {
        return new MessageGeneratorImpl();
    }

    @Bean
    public Game game() {
        return new GameImpl();
    }

    @Bean
    public NumberGenerator numberGenerator() {
        return new NumberGeneratorImpl();
    }
}
