package com.edu.pars.sax;

import com.edu.pars.CommandReader;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static com.edu.pars.utils.TestConst.DEFAULT_FILE_PATH;
import static org.junit.Assert.*;

public class ParserSAXTest {

    @BeforeClass
    public static void init(){
        CommandReader.filePath = DEFAULT_FILE_PATH;
    }
    @Test
    public void parse_DocumentToModelListBySAX_NotEmpty()
            throws IOException, SAXException, ParserConfigurationException {
        Assert.assertFalse(ParserSAX.parse().isEmpty());
    }
}