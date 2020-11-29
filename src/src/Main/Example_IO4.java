package Main;

import java.io.*;

public class Example_IO4 {
    public static void main(String[] args) throws IOException {
        int n = -1;
        ByteArrayOutputStream outByte = new ByteArrayOutputStream();
        byte[] a = "你好,内存条!".getBytes();
        outByte.write(a);
        outByte.close();
        ByteArrayInputStream inByte = new ByteArrayInputStream(outByte.toByteArray());
        byte[] tom = new byte[16];
        while((n=inByte.read(tom,0,16))!=-1){
            System.out.print(new String(tom,0,n));
        }
        inByte.close();

        System.out.println();

        char[] jerry = new char[8];
        CharArrayWriter outChar = new CharArrayWriter();
        char[] b = "你好，这是个数组流!".toCharArray();
        outChar.write(b);
        outByte.close();
        CharArrayReader inChar = new CharArrayReader(outChar.toCharArray());
        while ((n = inChar.read(jerry,0,8))!=-1){
            System.out.print(new String(jerry,0,n));
        }
        inChar.close();
    }
}
