package Shape.Pology;

import java.io.Serializable;

/**
 * @author huangbiao
 */
public class Circle extends Shape implements Serializable {
    float r;
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
    @Override
    public double area(){
        return r*r*3.1415;
    }

}
