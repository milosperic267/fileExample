/* ****************************************************************************
 *
 * [ App.java ]
 *
 * COPYRIGHT (c) 2002 - 2021 by Allianz-Suisse, Zürich, Switzerland.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Allianz-Suisse.
 *
 ******************************************************************************/
package ch.allianz.fileReader;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {

        String test = "C:\\dev\\test.txt";
        String zauberlehrling = "C:\\dev\\derZauberlehrling.txt";


        CountAmountOfWords countWords = new CountAmountOfWords(zauberlehrling);

        System.out.println(countWords.countAllWords());
        System.out.println(countWords.countFrequencyPerWord());

    }

}
