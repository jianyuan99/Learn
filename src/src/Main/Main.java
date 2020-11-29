package Main;

import java.util.StringTokenizer;

/**
 * @author huangbiao
 */
public class Main {
    public static void main(String[] args){
        StringTokenizer tokenizer = new StringTokenizer("a,b,c,d,e;f,g,是,你",";");
        while(tokenizer.hasMoreTokens()){
            System.out.println(tokenizer.nextToken());
        }
        StringBuffer stringBuffer=new StringBuffer("abc");
        stringBuffer.insert(2,"0");
        stringBuffer.append("d");
        System.out.println(stringBuffer);

    }
}
