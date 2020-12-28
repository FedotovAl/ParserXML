package com.edu.pars.view;

import com.edu.pars.CourseModel;

import static com.edu.pars.TagNameConstants.*;
import static com.edu.pars.view.ViewConstants.*;

public class TablePrinter {

    public static void printTableHeader(){
        System.out.format(ID_COLUMN_WIDTH, ID_TAG + VERTICAL_SEPARATOR);
        System.out.format(NAME_COLUMN_WIDTH, NAME_TAG + VERTICAL_SEPARATOR);
        System.out.format(AUTHOR_COLUMN_WIDTH, AUTHOR_TAG + VERTICAL_SEPARATOR);
        System.out.format(CREATE_DATE_COLUMN_WIDTH, CREATE_DATE_TAG + VERTICAL_SEPARATOR);
        System.out.format(TASKS_COLUMN_WIDTH, TASKS_TAG + VERTICAL_SEPARATOR);

        System.out.println("\n" + HEADER_HORIZONTAL_SEPARATOR);
    }

    public static void printTableValues(CourseModel course){
        System.out.format(ID_COLUMN_WIDTH, course.getId() + VERTICAL_SEPARATOR);
        System.out.format(NAME_COLUMN_WIDTH, course.getName() + VERTICAL_SEPARATOR);
        System.out.format(AUTHOR_COLUMN_WIDTH, course.getAuthor() + VERTICAL_SEPARATOR);
        System.out.format(CREATE_DATE_COLUMN_WIDTH, course.getCreateDate() + VERTICAL_SEPARATOR);
        System.out.format(TASKS_COLUMN_WIDTH, course.getTaskList() + VERTICAL_SEPARATOR);

        System.out.println();
    }

}
