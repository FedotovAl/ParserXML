package com.edu.pars.dom;

import com.edu.pars.CommandReader;
import com.edu.pars.CourseModel;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.edu.pars.TagNameConstants.*;
import static com.edu.pars.dom.Utility.isCorrect;
import static com.edu.pars.dom.Utility.isElement;

public class ParserDOM {
    public static List<CourseModel> parse() throws ParserConfigurationException, IOException, SAXException {
        List<CourseModel> courses = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        try {
            Document document = builder.parse(new File(CommandReader.filePath));

            Element element = document.getDocumentElement();
            NodeList courseList = element.getElementsByTagName(COURSE_TAG);

            for (int i = 0; i < courseList.getLength(); i++) {
                courses.add(createCourseModel(courseList.item(i).getChildNodes()));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return courses;
    }
    private static CourseModel createCourseModel(NodeList nodeList){
        Node node;
        CourseModel course = new CourseModel();
        for (int i = 0; i < nodeList.getLength(); i++){
            node = nodeList.item(i);
            if (isElement(node)) {
                String value="";
                if (Utility.isCorrect(node)){
                    Text text = (Text) node.getFirstChild();
                    value = text.getData().trim();
                }
                if (node.getNodeName().equals(ID_TAG)) {
                    course.setId(value);
                }
                if (node.getNodeName().equals(NAME_TAG)){
                    course.setName(value);
                }
                if (node.getNodeName().equals(AUTHOR_TAG)){
                    course.setAuthor(value);
                }
                if (node.getNodeName().equals(CREATE_DATE_TAG)){
                    course.setCreateDate(value);
                }
                if (node.getNodeName().equals(TASKS_TAG)){
                    value = createTaskList(node.getChildNodes());
                    course.setTaskList(value);
                }
            }
        }
        return course;
    }

    private static String createTaskList(NodeList nodeList){
        String taskStr = "[";
        Node node;
        for (int i = 0; i < nodeList.getLength() - 1; i++) {
            node = nodeList.item(i);
            if (isElement(node)) {
                String value = "";
                if (isCorrect(node)) {
                    Text text = (Text) node.getFirstChild();
                    value = text.getData().trim();
                }
                if (i == nodeList.getLength() - 2) {
                    taskStr = taskStr + value;
                } else {
                    taskStr = taskStr + value + ",";
                }
            }
        }
        taskStr += "]";
        return taskStr;
    }
}
