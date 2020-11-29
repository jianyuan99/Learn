import java.io.*;
import java.util.StringTokenizer;

public class Test_IO {
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
        OutputStream out = System.out;
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(out));
        //这是一个缓存流，需满足条件，即缓存满或者执行强行写时才能输出
        bufferedWriter.flush();
        String str = "";

        while (!(str = bufferedReader.readLine()).equals("bye")) {
            System.out.println(str);
            StringTokenizer stringTokenizer = new StringTokenizer(str, " ");
            while(stringTokenizer.hasMoreTokens()){
                System.out.println(stringTokenizer.nextToken());
            }
        }
        System.out.println("End!");
    }

}
