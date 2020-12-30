package com.edu.pars;

import com.edu.pars.dom.ParserDOM;
import com.edu.pars.sax.ParserSAX;
import com.edu.pars.view.TablePrinter;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        while(true) {
            System.out.println("enter command: ");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            CommandReader.readCommand(command);

            switch (CommandReader.parserName){
                case "dom": {
                    List<CourseModel> courses = ParserDOM.parse();
                    chooseCoursesByName(courses, CommandReader.keyString);
                    break;
                }
                case "sax": {
                    List<CourseModel> courses = ParserSAX.parse();
                    chooseCoursesByName(courses, CommandReader.keyString);
                    break;
                }
                default:{
                    System.out.println("Incorrect parser name");
                }
            }
        }
    }

    private static void chooseCoursesByName(List<CourseModel> courseList, String str){
        TablePrinter.printTableHeader();
        for (CourseModel c : courseList){
            if (str.equals("-all")){
                TablePrinter.printTableValues(c);
            } else if (c.getName().toLowerCase().contains(str)){
                TablePrinter.printTableValues(c);
            }
        }
    }
}