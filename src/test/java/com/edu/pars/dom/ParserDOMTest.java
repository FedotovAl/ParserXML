package com.edu.pars.dom;

import com.edu.pars.CommandProvider;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static com.edu.pars.utils.TestConst.DEFAULT_FILE_PATH;

public class ParserDOMTest {

    @BeforeClass
    public static void init(){
        CommandProvider.filePath = DEFAULT_FILE_PATH;
    }
    @Test
    public void parse_DocumentToModelListByDOM_NotEmpty()
            throws IOException, SAXException, ParserConfigurationException {
        Assert.assertFalse(ParserDOM.parse().isEmpty());
    }
}