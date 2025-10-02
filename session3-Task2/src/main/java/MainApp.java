import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("springDI2/applicationContext.xml");

        Vehicle car = context.getBean("car", Vehicle.class);
        car.saveIntoDB();

        Vehicle plane = context.getBean("plane", Vehicle.class);
        plane.saveIntoDB();
    }
}