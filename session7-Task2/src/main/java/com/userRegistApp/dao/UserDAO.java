package com.userRegistApp.dao;

import com.userRegistApp.model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UserDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/vehiclesdb?useSSL=false&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "AB.Siraj@El-Deen";

    public boolean saveUser(User user) {
        boolean status = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            String sql = "INSERT INTO users (first_name, last_name, email, birthdate, city) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getBirthdate());
            ps.setString(5, user.getCity());

            int rows = ps.executeUpdate();
            status = rows > 0;

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
}
