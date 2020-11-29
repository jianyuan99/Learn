package Shape.Pology;

import Shape.Shape;

public class Circle implements Shape {
    float r;
    public double area(){
        return r*r*3.14159;
    }
    public Circle(float r){
        this.r=r;
    }

    public float getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    }

    public Circle(){
        r=0.0f;
    }

}
