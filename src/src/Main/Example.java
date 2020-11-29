package Main;

/**
 * @author huangbiao
 */
import Shape.Pology.Shape;

import java.io.File;
import java.lang.*;
import java.lang.reflect.Field;
import java.math.*;
public class Example {
     /*static double get_Area(Shape s){
        return s.area();
    }
     */
    public static void main(String[] args)  {
       /*Shape[] shape=new Shape[3];
       shape[0]=new Triangle(1,1);
       shape[1]=new Circle(1);
       shape[2]=new Rectangle(1,1);
       for(int i=0;i<3;i++){
           System.out.println(get_Area(shape[i]));
        */
        //创建circle对象
        Shape circle=new Shape() {
            private double r;

            @Override
            public double area() {
                return r*r*Math.PI;
            }
        };
        Class csCir=circle.getClass();
        try {
            Field f1=csCir.getDeclaredField("r");
            f1.setAccessible(true);
            f1.set(circle,1);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println("this is a circle:"+circle.area());

        //创建rectangle对象
        Shape rectangle=new Shape() {
            private double width;
            private double height;

            @Override
            public double area() {
                return width*height;
            }
        };
        Class rec=rectangle.getClass();
        try {
            Field rec_h=rec.getDeclaredField("height");
            Field rec_w=rec.getDeclaredField("width");
            rec_h.setAccessible(true);
            rec_w.setAccessible(true);
            try {
                rec_h.set(rectangle,1.0);

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        System.out.println("this is a rectangle:"+rectangle.area());

        //创建triangle对象
        Shape triangle=new Shape() {
            private double width;
            private double height;

            @Override
            public double area() {
                return width*height*0.5;
            }
        };
        System.out.println("this is a triangle:"+triangle.area());
        String s=new String("ss");

     }
}
