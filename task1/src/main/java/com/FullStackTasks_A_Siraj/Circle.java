/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.FullStackTasks_A_Siraj;

/**
 *
 * @author NV_User
 */
public class Circle implements Shape{
    float radius;
    
     public Circle(float radius) {
        this.radius = radius;
    }
     
    @Override
    public float getArea() {
        return 3.14f * radius * radius;
    }
    
}
