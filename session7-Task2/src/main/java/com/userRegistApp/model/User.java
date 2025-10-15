package com.userRegistApp.model;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String birthdate;
    private String city;

    public User() {
    }

    public User(String firstName, String lastName, String email, String birthdate, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthdate = birthdate;
        this.city = city;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getters and setters
    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getCity() {
        return city;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
