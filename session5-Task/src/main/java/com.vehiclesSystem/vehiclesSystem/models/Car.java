package com.vehiclesSystem.vehiclesSystem.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter @Setter @ToString
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Car implements Vehicle {
    private String id;
    private String brand;
    private String type;

    // Constructor injection of DatabaseOperations done in config/service layer when creating Car bean instance
    public Car() { }

    public Car(String id, String brand, String type) {
        this.id = id;
        this.brand = brand;
        this.type = type;
    }
}
