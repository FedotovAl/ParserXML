package com.edu.pars;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static com.edu.pars.TablePrinter.printTableValues;

public class Application {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        String defaultFilePath = "src/main/resources/StudentReport.xml";
        while(true) {
            System.out.println("Enter command: ");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            CommandReader.readCommand(command);

            if (CommandReader.parserName.equals("dom")) {

                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document document = builder.parse(new File(CommandReader.filePath));

                Element element = document.getDocumentElement();
                NodeList courseList = element.getElementsByTagName("course");
                TablePrinter.printTableHeader(courseList.item(0).getChildNodes());

                if (CommandReader.keyString.equals("-all")) {
                    for (int i = 0; i < courseList.getLength(); i++) {
                        printTableValues(courseList.item(i).getChildNodes());
                    }
                } else {
                    paramStart(courseList, CommandReader.keyString);
                }
            } else {
                System.out.println("incorrect parser name");
            }
        }
    }

    public static void paramStart(NodeList nodeList, String str){
        String value = "";
        for (int i = 0; i < nodeList.getLength(); i++){
            Text text = (Text) nodeList.item(i).getChildNodes().item(3).getFirstChild();
            value = text.getData().trim();
            if (value.contains(str)){
                printTableValues(nodeList.item(i).getChildNodes());
            }
        }
    }
}