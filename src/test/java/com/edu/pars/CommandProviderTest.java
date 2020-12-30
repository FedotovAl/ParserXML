package com.edu.pars;

import org.junit.Assert;
import org.junit.Test;

import static com.edu.pars.utils.TestConst.*;

public class CommandProviderTest {

    @Test
    public void readCommand_ValidCommandWithDOM_Equals() {
        CommandProvider.readCommand("dom src/main/resources/StudentReport.xml");
        Assert.assertEquals("dom", CommandProvider.parserName);
        Assert.assertEquals(DEFAULT_FILE_PATH, CommandProvider.filePath);
        Assert.assertEquals(DEFAULT_KEY_WORD, CommandProvider.keyString);
    }
    @Test
    public void readCommand_validCommandWithSAX_Equals(){
        CommandProvider.readCommand("sax src/main/resources/StudentReport.xml java");
        Assert.assertEquals("sax", CommandProvider.parserName);
        Assert.assertEquals(DEFAULT_FILE_PATH, CommandProvider.filePath);
        Assert.assertEquals("java", CommandProvider.keyString);
    }
    @Test
    public void readCommand_NotValidCommand_Equals(){
        CommandProvider.readCommand("sax");
        Assert.assertEquals("", CommandProvider.parserName);
        Assert.assertEquals("", CommandProvider.filePath);
        Assert.assertEquals("", CommandProvider.keyString);
    }
}