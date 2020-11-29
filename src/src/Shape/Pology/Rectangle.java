package Shape.Pology;

/**
 * @author huangbiao
 */
public class Rectangle extends Shape{
    float width;
    float height;
    public  Rectangle(float w,float h){
        width=w;
        height=h;
    }
    public Rectangle(){
        width=0.0f;
        height=0.0f;
    }
    @Override
    public double area(){
        return width*height;
    }
}
