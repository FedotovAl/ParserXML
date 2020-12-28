package com.edu.pars.sax;

import com.edu.pars.CommandReader;
import com.edu.pars.CourseModel;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ParserSAX {
    public static List<CourseModel> parse() throws ParserConfigurationException, SAXException, IOException {
        MainHandler mainHandler = new MainHandler();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        try {
            parser.parse(new File(CommandReader.filePath), mainHandler);
        } catch (Exception e){
            System.out.println(e);
        }
        return mainHandler.getCourses();
    }
}
