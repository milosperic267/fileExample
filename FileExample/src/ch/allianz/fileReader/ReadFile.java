/* ****************************************************************************
 *
 * [ ReadFile.java ]
 *
 * COPYRIGHT (c) 2002 - 2021 by Allianz-Suisse, Zürich, Switzerland.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Allianz-Suisse.
 *
 ******************************************************************************/
package ch.allianz.fileReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadFile {

    private String path;
    private BufferedReader bufferdReader;

    public ReadFile(String path) {
        this.path = path;
    }

    private void bufferReader() throws IOException {
        Path file = Paths.get(path);
        bufferdReader = Files.newBufferedReader(file, StandardCharsets.UTF_8);
    }

    public String readLine() throws IOException {
        String line;
        line = bufferdReader.readLine();
        return line;
    }

    private void searchFile() throws IOException {
        try {
            bufferReader();
        } catch (IOException e) {
            throw new IOException("File " + path + " not found");
        }
    }


    public String readFromFile() throws IOException {

        searchFile();
        String line = null;
        try {
            line = readLine();

        } catch (IOException e) {
            throw new IOException("File " + path + " is not a text file");
        }
        return line;
    }

}

