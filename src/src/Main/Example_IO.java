package Main;

import java.io.*;
import Shape.Pology.Circle;
public class Example_IO {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream in = new FileInputStream("test_txt/Ex3_2.html");
        FileOutputStream out = new FileOutputStream("test_txt/out.txt");
        int c;
        while ((c=in.read())!=-1){
            out.write(c);
            System.out.println(c);
        };
        in.close();
        out.close();
        System.out.println("this is the Stream end!");

        FileReader in1 = new FileReader("test_txt/in.txt");
        FileWriter out2 = new FileWriter("test_txt/out2.txt");

        BufferedReader bufferedReader = new BufferedReader(in1);
        BufferedWriter bufferedWriter = new BufferedWriter(out2);
        String str = null;
        while ((str = bufferedReader.readLine()) != null){
            bufferedWriter.write(str);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
        in1.close();
        out2.close();
        bufferedReader.close();
        bufferedWriter.close();
        System.out.println("this is the BufferedReader end!");
   }
}
