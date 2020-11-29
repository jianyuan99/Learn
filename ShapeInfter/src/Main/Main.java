package Main;

import Shape.Pology.Circle;
import Shape.Pology.Rectangle;
import Shape.Pology.Triangle;

public class Main {
    public static void main(String[] args){
        Triangle tri=new Triangle(1,1);
        System.out.println(tri.area());
        Rectangle rec=new Rectangle(1,1);
        System.out.println(rec.area());
        Circle cir=new Circle(1);
        System.out.println(cir.area());
    }
}
