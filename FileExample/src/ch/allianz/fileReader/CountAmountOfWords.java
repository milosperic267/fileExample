/* ****************************************************************************
 *
 * [ CountWords.java ]
 *
 * COPYRIGHT (c) 2002 - 2021 by Allianz-Suisse, Zürich, Switzerland.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Allianz-Suisse.
 *
 ******************************************************************************/
package ch.allianz.fileReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class CountAmountOfWords implements Consume {

    ReadFile rf;
    private int size;
    private String path;

    public CountAmountOfWords(String path) {

        rf = new ReadFile(path);
    }

    private String remove(String word) {

        word = word.replace(".", "");
        word = word.replace("!", "");
        word = word.replace("?", "");
        word = word.replace(",", "");
        return word;
    }

 
    public int countAllWords() throws IOException {

        String line = rf.readFromFile();
        int total = 0;
        try {
            while (line != null) {
                StringTokenizer tokens = new StringTokenizer(line);
                int lineTotal = 0;
                while (tokens.hasMoreTokens()) {
                    System.out.println(tokens.nextToken());
                    lineTotal++;
                }
                total = total + lineTotal;
                line = rf.readLine();
            }

        } catch (IOException e) {
            throw new IOException("File " + path + " is not a text file");
        }
        return total;
    }

    public Map<String, Integer> countFrequencyPerWord() throws IOException {

        String line = rf.readFromFile();
        Map<String, Integer> frequency = new HashMap<>();
        try {
            while (line != null) {
                if (!line.trim().equals("")) {
                    String[] words = line.split(" ");

                    for (String word : words) {
                        if (word == null || word.trim().equals("")) {
                            continue;
                        }
                        String word1 = word.toLowerCase();
                        word1 = remove(word1);

                        if (frequency.containsKey(word1)) {
                            frequency.put(word1, frequency.get(word1) + 1);
                        } else {
                            frequency.put(word1, 1);
                        }
                    }
                }
                line = rf.readLine();
            }
        } catch (IOException e) {
            throw new IOException("File " + path + " is not a text file");
        }
        return frequency;
    }

    public int countAmountOfWords() throws IOException {

        String line = rf.readFromFile();
        Set<String> set = new HashSet<>();
        try {
            while (line != null) {
                if (!line.trim().equals("")) {
                    String[] words = line.split(" ");

                    for (String word : words) {
                        if (word == null || word.trim().equals("")) {
                            continue;
                        }
                        String word1 = word.toLowerCase();
                        word1 = remove(word1);
                        set.add(word1);
                    }
                }
                line = rf.readLine();
            }
        } catch (IOException e) {
            throw new IOException("File " + path + " is not a text file");
        }
        return set.size();
    }

    @Override
    public void consume() throws IOException {
        String line = rf.readFromFile();
        Set<String> set = new HashSet<>();
        try {
            while (line != null) {
                if (!line.trim().equals("")) {
                    String[] words = line.split(" ");

                    for (String word : words) {
                        if (word == null || word.trim().equals("")) {
                            continue;
                        }
                        String word1 = word.toLowerCase();
                        word1 = remove(word1);
                        set.add(word1);
                    }
                }
                line = rf.readLine();
            }
        } catch (IOException e) {
            throw new IOException("File " + path + " is not a text file");
        }
        size = set.size();
    }

}
