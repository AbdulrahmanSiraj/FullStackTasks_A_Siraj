import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("springIOC/applicationContext.xml");
        Shape circle = container.getBean("circle", Shape.class);
        circle.draw();

        Shape rectangle = container.getBean("rectangle", Shape.class);
        rectangle.draw();
    }
    
}
