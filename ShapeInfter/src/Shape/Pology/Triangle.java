package Shape.Pology;

import Shape.Shape;

public class Triangle implements Shape {
    float width;
    float height;
    public Triangle(float w,float h){
        width=w;
        height=h;
    }
    public Triangle(){
        width=0.0f;
        height=0.0f;
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

    public double area(){
        return width*height*0.5;
    }
}
