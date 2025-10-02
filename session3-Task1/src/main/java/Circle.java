public class Circle implements Shape{
    private float radius;
    private Draw draw;
    
     public Circle(float radius, Draw draw) {
        this.radius = radius;
        this.draw = draw;
    }
     
    @Override
    public float getArea() {
        return 3.14f * radius * radius;
    }
    
    @Override
    public void draw() {
        draw.draw("Circle");
    }
    
}
