import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;

import ch.allianz.fileReader.ReadFile;

/* ****************************************************************************
 *
 * [ TestReadFile.java ]
 *
 * COPYRIGHT (c) 2002 - 2021 by Allianz-Suisse, Zürich, Switzerland.
 * All rights reserved. This material contains unpublished, copyrighted
 * work including confidential and proprietary information of Allianz-Suisse.
 *
 ******************************************************************************/

public class TestReadFile {

    @Test(expected = IOException.class)
    public void testFileNotFound() throws IOException {
        ReadFile rf = new ReadFile();
        rf.readFromFile("C:\\dev\\tes.txt");

    }

    @Test(expected = IOException.class)
    public void testFileNotATextFile() throws IOException {
        ReadFile rf = new ReadFile();
        rf.readFromFile("C:\\dev\\Download.png");
    }

    @Test
    public void testHappyFlow() {

        ReadFile rf = new ReadFile();
        try {
            rf.readFromFile("C:\\dev\\test.txt");
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }

}
