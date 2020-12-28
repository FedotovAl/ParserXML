package com.edu.pars.sax;

import com.edu.pars.CourseModel;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

import static com.edu.pars.TagNameConstants.*;

public class MainHandler extends DefaultHandler {

    private List<CourseModel> courses = new ArrayList<>();

    private CourseModel course;
    private String currentElement;
    private String tskLst;
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
        if (currentElement.equals(COURSE_TAG)){
            course = new CourseModel();
        }
        if (currentElement.equals(TASKS_TAG)){
            tskLst = "";
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals(TASKS_TAG) && tskLst != null && course != null){
            if (tskLst.isEmpty()){
                tskLst = "[]";
            } else {
                tskLst = "[" + tskLst.substring(0, tskLst.length() - 1) + "]";
            }
            course.setTaskList(tskLst);
            tskLst = null;
        }
        if (qName.equals(COURSE_TAG) && course != null){
            courses.add(course);
            course = null;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String text = new String(ch, start, length);
        if (course != null && !text.trim().isEmpty()){
            if (currentElement.equals(ID_TAG)){
                course.setId(text);
            }
            if (currentElement.equals(NAME_TAG)){
                course.setName(text);
            }
            if (currentElement.equals(AUTHOR_TAG)){
                course.setAuthor(text);
            }
            if (currentElement.equals(CREATE_DATE_TAG)){
                course.setCreateDate(text);
            }
            if (currentElement.equals(TASK_ID_TAG) && tskLst != null){
                tskLst = tskLst + text + ",";
            }
        }
    }
    public List<CourseModel> getCourses() {
        return courses;
    }
}
