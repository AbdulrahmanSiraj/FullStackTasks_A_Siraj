package com.vehiclesSystem.vehiclesSystem;

import com.vehiclesSystem.config.Config;
import com.vehiclesSystem.controller.BikeController;
import com.vehiclesSystem.controller.CarController;
import com.vehiclesSystem.controller.PlaneController;
import com.vehiclesSystem.models.Bike;
import com.vehiclesSystem.models.Car;
import com.vehiclesSystem.models.Plane;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
            new AnnotationConfigApplicationContext(Config.class);

        // ==== CAR ====
        CarController carController = ctx.getBean(CarController.class);
        Car car = new Car("car-001", "Toyota", "ECONOMY");
        carController.saveVehicle(car);



        PlaneController planeController = ctx.getBean(PlaneController.class);
        Plane plane = new Plane("plane-001", "Boeing", "300");
        planeController.saveVehicle(plane);


        BikeController bikeController = ctx.getBean(BikeController.class);
        Bike bike = new Bike("bike-001", "Yamaha", "mock");
        bikeController.saveVehicle(bike);


        System.out.println("Trying delete for car-001...");
        carController.deleteVehicle("car-001");

        System.out.println("Find plane by id: " + planeController.findVehicle("plane-001"));

        System.out.println("List all bikes:");
        bikeController.listAllVehicles().forEach(System.out::println);

        ctx.close();
    }
}
