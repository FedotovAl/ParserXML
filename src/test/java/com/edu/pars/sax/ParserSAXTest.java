package com.edu.pars.sax;

import com.edu.pars.CommandProvider;
import com.edu.pars.CourseModel;
import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

import static com.edu.pars.utils.TestUtils.*;

public class ParserSAXTest {

    @Test
    public void parse_DocumentToModelListBySAX()
            throws IOException, SAXException, ParserConfigurationException {
        CommandProvider.filePath = DEFAULT_FILE_PATH;
        List<CourseModel> courses = ParserSAX.parse();
        Assert.assertFalse(courses.isEmpty());
        Assert.assertEquals(8, courses.size());
        Assert.assertEquals(FIRST_COURSE, courses.get(0));
        Assert.assertEquals(LAST_COURSE, courses.get(courses.size() - 1));
    }
    @Test
    public void parse_TestDocumentToModeListBySAX()
            throws IOException, SAXException, ParserConfigurationException {
        CommandProvider.filePath = TEST_FILE_PATH;
        List<CourseModel> courses = ParserSAX.parse();
        Assert.assertFalse(courses.isEmpty());
        Assert.assertEquals(1, courses.size());
        Assert.assertEquals(TEST_COURSE, courses.get(0));
    }
}