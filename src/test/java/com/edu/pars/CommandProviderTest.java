package com.edu.pars;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static com.edu.pars.utils.TestUtils.*;
import static org.junit.Assert.assertEquals;

public class CommandProviderTest {

    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    final PrintStream originalOut = System.out;


    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }
    @Test
    public void readCommand_ValidCommandWithDOM_Equals() {
        CommandProvider.readCommand("dom src/main/resources/StudentReport.xml");
        assertEquals("dom", CommandProvider.parserName);
        assertEquals(DEFAULT_FILE_PATH, CommandProvider.filePath);
        assertEquals(DEFAULT_KEY_WORD, CommandProvider.keyString);
    }
    @Test
    public void readCommand_validCommandWithSAX_Equals(){
        CommandProvider.readCommand("sax src/main/resources/StudentReport.xml java");
        assertEquals("sax", CommandProvider.parserName);
        assertEquals(DEFAULT_FILE_PATH, CommandProvider.filePath);
        assertEquals("java", CommandProvider.keyString);
    }
    @Test
    public void readCommand_NotValidCommand_Equals(){
        CommandProvider.readCommand("sax");
        assertEquals("", CommandProvider.parserName);
        assertEquals("", CommandProvider.filePath);
        assertEquals("", CommandProvider.keyString);
        assertEquals("Filepath is empty\n", outContent.toString());
    }
}