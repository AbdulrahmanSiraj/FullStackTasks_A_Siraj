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
public class Plane implements Vehicle {
    private String id;
    private String brand;
    private String type;

    public Plane() { }

    public Plane(String id, String brand, String type) {
        this.id = id;
        this.brand = brand;
        this.type = type;
    }

    // setter injection for DatabaseOperations will be in configuration or a controller
}
