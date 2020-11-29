package Shape.Pology;

/**
 * @author huangbiao
 */
public class Triangle extends Shape {
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
    @Override
    public double area(){
        return width*height*0.5;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }
}
