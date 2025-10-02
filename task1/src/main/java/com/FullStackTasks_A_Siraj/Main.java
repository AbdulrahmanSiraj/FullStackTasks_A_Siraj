
package com.FullStackTasks_A_Siraj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("springIOC/applicationContext.xml");
        Shape circle = container.getBean("circle", Circle.class);
        System.out.println("Circle area: " + circle.getArea());
        
        Shape rectangle = container.getBean("rectangle", Rectangle.class);
        System.out.println("Rectangle area: " + rectangle.getArea());
    }
    
}
