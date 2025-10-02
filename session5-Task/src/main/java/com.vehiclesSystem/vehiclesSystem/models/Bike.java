package com.vehiclesSystem.vehiclesSystem.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.vehiclesSystem.dao.DatabaseOperations;

@Getter @Setter @ToString
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Bike implements Vehicle {
    private String id;
    private String brand;
    private String type;

    // Field injection (not recommended in general, but required per assignment)
    @Autowired
    private DatabaseOperations databaseOperations;

    public Bike() { }

    public Bike(String id, String brand, String type) {
        this.id = id;
        this.brand = brand;
        this.type = type;
    }
}
