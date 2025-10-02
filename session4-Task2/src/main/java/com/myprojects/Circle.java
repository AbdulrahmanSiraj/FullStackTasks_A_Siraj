package com.myprojects;

public class Circle implements Shape{
    private Draw2D draw2D;
    private Draw3D draw3D;

    // constructor injection
    public Circle(Draw2D draw2D, Draw3D draw3D){
        this.draw2D = draw2D;
        this.draw3D = draw3D;
    }

    @Override
    public void drawShape() {
        draw2D.draw2dShape("Circle");
        draw3D.draw3dShape("Circle");
    }
}
