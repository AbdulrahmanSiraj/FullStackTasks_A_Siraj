/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.FullStackTasks_A_Siraj;

/**
 *
 * @author NV_User
 */
public class Rectangle implements Shape{
    float length;
    float width;
    
    public Rectangle(float length, float width){
        this.length = length;
        this.width = width;
    }
    
    @Override
    public float getArea() {
        return length * width;
    }
    
}
