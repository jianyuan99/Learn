package Main;

import java.io.*;

public class Example_IO5 {
    public static void main(String[] args) throws IOException {
        int n = -1;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(bos);
        dos.writeInt(129);
        byte[] result = new byte[4];
//        result = bos.toByteArray();
        ByteArrayInputStream inByte = new ByteArrayInputStream(bos.toByteArray());
        while((n=inByte.read(result,0,4))!=-1){}
        inByte.close();


        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }

        ByteArrayInputStream ios = new ByteArrayInputStream(bos.toByteArray());
        DataInputStream ros = new DataInputStream(ios);
        int i= ros.readInt();
        System.out.println(i);
    }
}
