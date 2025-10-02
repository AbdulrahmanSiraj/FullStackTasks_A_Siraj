package com.vehiclesSystem.vehiclesSystem.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.vehiclesSystem.models.Vehicle;

@Component
public class DatabaseOperations {

    @Value("${db.url}")
    private String url;

    @Value("${db.username}")
    private String username;

    @Value("${db.password}")
    private String password;

    private Connection connection;

    @PostConstruct
    public void connectToDatabase() {
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection to database established ...");
        } catch (SQLException e) {
            throw new RuntimeException("Failed to connect to DB", e);
        }
    }

    @PreDestroy
    public void disconnectFromDatabase() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection to database closed ...");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Basic save to appropriate table depending on class name
    public void save(Vehicle vehicle) {
        String table = tableNameFor(vehicle);
        String sql = "INSERT INTO " + table + " (id, brand, type) VALUES (?, ?, ?)";

        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, vehicle.getId());
            st.setString(2, vehicle.getBrand());
            st.setString(3, vehicle.getType());
            st.executeUpdate();
            System.out.println("Saved " + vehicle + " to " + table);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Vehicle vehicle) {
        String table = tableNameFor(vehicle);
        String sql = "UPDATE " + table + " SET brand = ?, type = ? WHERE id = ?";
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, vehicle.getBrand());
            st.setString(2, vehicle.getType());
            st.setString(3, vehicle.getId());
            st.executeUpdate();
            System.out.println("Updated " + vehicle + " in " + table);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Class<? extends Vehicle> cls, String id) {
        String table = tableNameForClass(cls);
        String sql = "DELETE FROM " + table + " WHERE id = ?";
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, id);
            st.executeUpdate();
            System.out.println("Deleted id=" + id + " from " + table);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Vehicle searchById(Class<? extends Vehicle> cls, String id) {
        String table = tableNameForClass(cls);
        String sql = "SELECT id, brand, type FROM " + table + " WHERE id = ?";
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, id);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    String rid = rs.getString("id");
                    String brand = rs.getString("brand");
                    String type = rs.getString("type");
                    if (cls.getSimpleName().equalsIgnoreCase("Car")) {
                        com.vehiclesSystem.models.Car c = new com.vehiclesSystem.models.Car(rid, brand, type);
                        return c;
                    } else if (cls.getSimpleName().equalsIgnoreCase("Plane")) {
                        com.vehiclesSystem.models.Plane p = new com.vehiclesSystem.models.Plane(rid, brand, type);
                        return p;
                    } else {
                        com.vehiclesSystem.models.Bike b = new com.vehiclesSystem.models.Bike(rid, brand, type);
                        return b;
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<Vehicle> getAllVehicles(Class<? extends Vehicle> cls) {
        List<Vehicle> result = new ArrayList<>();
        String table = tableNameForClass(cls);
        String sql = "SELECT id, brand, type FROM " + table;
        try (PreparedStatement st = connection.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                String rid = rs.getString("id");
                String brand = rs.getString("brand");
                String type = rs.getString("type");
                if (cls.getSimpleName().equalsIgnoreCase("Car")) {
                    result.add(new com.vehiclesSystem.models.Car(rid, brand, type));
                } else if (cls.getSimpleName().equalsIgnoreCase("Plane")) {
                    result.add(new com.vehiclesSystem.models.Plane(rid, brand, type));
                } else {
                    result.add(new com.vehiclesSystem.models.Bike(rid, brand, type));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    private String tableNameFor(Vehicle v) {
        return tableNameForClass(v.getClass());
    }

    private String tableNameForClass(Class<?> cls) {
        if (cls.getSimpleName().equalsIgnoreCase("Car")) {
            return "car";
        } else if (cls.getSimpleName().equalsIgnoreCase("Plane")) {
            return "plane";
        } else {
            return "bike";
        }
    }


    public Connection getConnection() {
        return connection;
    }
}
