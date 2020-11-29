package Main;

import java.io.*;
import Shape.Pology.Circle;
public class Example_IO5 {
    public static void main(String[] args) throws IOException {
        Circle circle = new Circle(1);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(bos);
        dos.writeInt(129);
        byte[] result = bos.toByteArray();
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }

        ByteArrayInputStream ios = new ByteArrayInputStream(bos.toByteArray());
        DataInputStream ros = new DataInputStream(ios);
        int i= ros.readInt();
        System.out.println(i);
    }
}
