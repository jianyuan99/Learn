package Main;

import java.io.*;
import java.util.StringTokenizer;

public class Example_IO2 {
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
        OutputStream out = System.out;
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(out));
        bufferedWriter.flush();
        String str = null;
        System.out.println("请输入字符，按回车输出，输入bye结束");
        while (!(str = bufferedReader.readLine()).equals("bye")) {
            System.out.println(str);
//            StringTokenizer stringTokenizer = new StringTokenizer(str, " ");
//            while(stringTokenizer.hasMoreTokens()){
//                System.out.println(stringTokenizer.nextToken());
//            }
        }
        System.out.println("End!");
    }
}
