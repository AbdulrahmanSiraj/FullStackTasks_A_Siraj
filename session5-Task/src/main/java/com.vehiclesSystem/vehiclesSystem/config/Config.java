package com.vehiclesSystem.vehiclesSystem.config;

import com.vehiclesSystem.models.Car;
import com.vehiclesSystem.models.Plane;
import com.vehiclesSystem.models.Bike;
import com.vehiclesSystem.dao.DatabaseOperations;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.vehiclesSystem")
@PropertySource("classpath:application.properties")
public class Config {

}
