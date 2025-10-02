package com.myprojects;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        Circle circle = context.getBean("circle", Circle.class);
        circle.drawShape();

        Rectangle rectangle = context.getBean("rectangle", Rectangle.class);
        rectangle.drawShape();

        DatabaseOperations dbOps = context.getBean("databaseOperations", DatabaseOperations.class);
        ((ClassPathXmlApplicationContext)context).close();

    }
}