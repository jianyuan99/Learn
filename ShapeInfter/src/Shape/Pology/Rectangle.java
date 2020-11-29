package Shape.Pology;

import Shape.Shape;

public class Rectangle implements Shape {
    float width;
    float height;
    public Rectangle(float w,float h){
        width=w;
        height=h;
    }
    public Rectangle(){
        width=0.0f;
        height=0.0f;
    }
    public double area(){
        return width*height;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}
