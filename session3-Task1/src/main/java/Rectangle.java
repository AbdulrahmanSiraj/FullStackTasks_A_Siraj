public class Rectangle implements Shape{
    private float length;
    private float width;
    private Draw draw;
    
    public Rectangle(float length, float width){
        this.length = length;
        this.width = width;
    }
    
    public void setDraw(Draw draw) {
        this.draw = draw;
    }
    
    public void setSide(float length, float width) {
        this.length = length;
        this.width = width;
    }
    
    @Override
    public float getArea() {
        return length * width;
    }
    
    @Override
    public void draw() {
        draw.draw("Rectangle");
    }
    
}
