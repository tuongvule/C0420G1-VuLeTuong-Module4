package controllers;

import models.Teacher;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
    public static void main(String[] args) {
        AbstractApplicationContext context;
        context = new ClassPathXmlApplicationContext("WEB-INF/teacher-bean.xml");
        Teacher teacher = (Teacher) context.getBean("teacher");
        System.out.println("teacher");
    }
}
