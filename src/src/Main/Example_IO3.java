package Main;

import java.io.*;

public class Example_IO3 {
    public static void main(String[] args) throws IOException {

        FileReader in = new FileReader("test_txt/Ex3_2.html");
        FileWriter out = new FileWriter("test_txt/out2.txt");
        BufferedReader bufferedReader = new BufferedReader(in);
        PrintWriter pw = new PrintWriter(out, true);
        String str = null;

        while((str = bufferedReader.readLine())!=null) {
            System.out.println(str);
            pw.println(str);
        }
        in.close();
        out.close();
        bufferedReader.close();
        pw.close();
        System.out.println("End!");
    }
}
