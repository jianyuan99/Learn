package Main;

import java.io.*;

public class Example_IO5 {
    public static void main(String[] args) throws IOException {
        int n = -1;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(bos);
        dos.writeInt(129);
        byte[] result = new byte[4];
        ByteArrayInputStream inByte = new ByteArrayInputStream(bos.toByteArray());
        while((n=inByte.read(result,0,4))!=-1){}
        inByte.close();

        System.out.println("int转化为长度为4的字节数组");
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }

        ByteArrayInputStream ios = new ByteArrayInputStream(result);
        DataInputStream ros = new DataInputStream(ios);
        int i= ros.readInt();
        System.out.println("长度为4的字节数组转为int型");
        System.out.println(i);
    }
}
