package com.edu.pars;

import org.junit.Assert;
import org.junit.Test;

import static com.edu.pars.utils.TestConst.*;

public class CommandReaderTest {

    @Test
    public void readCommand_ValidCommandWithDOM_Equals() {
        CommandReader.readCommand("dom src/main/resources/StudentReport.xml");
        Assert.assertEquals("dom", CommandReader.parserName);
        Assert.assertEquals(DEFAULT_FILE_PATH, CommandReader.filePath);
        Assert.assertEquals(DEFAULT_KEY_WORD, CommandReader.keyString);
    }
    @Test
    public void readCommand_validCommandWithSAX_Equals(){
        CommandReader.readCommand("sax src/main/resources/StudentReport.xml java");
        Assert.assertEquals("sax", CommandReader.parserName);
        Assert.assertEquals(DEFAULT_FILE_PATH, CommandReader.filePath);
        Assert.assertEquals("java", CommandReader.keyString);
    }
    @Test
    public void readCommand_NotValidCommand_Equals(){
        CommandReader.readCommand("sax");
        Assert.assertEquals("", CommandReader.parserName);
        Assert.assertEquals("", CommandReader.filePath);
        Assert.assertEquals("", CommandReader.keyString);
    }
}