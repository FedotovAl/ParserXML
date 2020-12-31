package com.edu.pars.utils;

import com.edu.pars.CourseModel;

public class TestUtils {
    public static final String DEFAULT_FILE_PATH = "src/main/resources/studentreport.xml";
    public static final String TEST_FILE_PATH = "src/test/resources/testreport.xml";
    public static final String DEFAULT_KEY_WORD = "-all";
    public static final CourseModel FIRST_COURSE = new CourseModel();
    public static final CourseModel LAST_COURSE = new CourseModel();
    public static final CourseModel TEST_COURSE = new CourseModel();
    static {
        FIRST_COURSE.setId("1");
        FIRST_COURSE.setName("Overview of Eclipse IDE");
        FIRST_COURSE.setAuthor("Adam Smith");
        FIRST_COURSE.setCreateDate("2010-10-01");
        FIRST_COURSE.setTaskList("[1]");

        LAST_COURSE.setId("8");
        LAST_COURSE.setName("Процесс разработки программного обеспечени");
        LAST_COURSE.setAuthor("George Wagner");
        LAST_COURSE.setCreateDate("2016-11-25");
        LAST_COURSE.setTaskList("[16]");

        TEST_COURSE.setId("100");
        TEST_COURSE.setName("SomeName");
        TEST_COURSE.setCreateDate("2020-12-31");
        TEST_COURSE.setTaskList("[200]");
    }
}
