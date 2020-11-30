package Main;

import java.io.Serializable;

import java.io.*;

/**
 * @author huangbiao
 */
class Circle implements Serializable {
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

    public double area(){
        return r*r*3.1415;
    }

}


public class Example_IO6 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FileOutputStream out = new FileOutputStream("test_txt/out2.txt");
        ObjectOutputStream objectOutput = new ObjectOutputStream(out);
        objectOutput.writeObject(new Circle(1.0f));

        FileInputStream in = new FileInputStream("test_txt/out2.txt");
        ObjectInputStream objectInput= new ObjectInputStream(in);
        Circle cir = (Circle)objectInput.readObject();
        System.out.println("这是一个Circle对象");
        System.out.println("面积是："+cir.area());

    }
}

