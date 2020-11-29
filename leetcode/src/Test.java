/**
 * @author huangbiao
 */
public class Test {
    public static int reverse(int x) {
        int temp=x;
        int temp2=x;
        int s=0;
        int a;
        double n=0;
        while(temp2!=0){
            temp2/=10;
            n++;
        }
        n--;
        while(temp!=0){
            a=temp%10;
            temp=temp/10;
            if((s<(Math.pow(2,31)-a*Math.pow(10,n)-1))||(s>(Math.pow(-2,31)-a*Math.pow(10,n)))) {
                s += a * Math.pow(10, n);
                n--;
            }
            else{
                return 0;
            }
        }
        return s;
    }
    public static void main(String[] args){
        int a=123456;
        System.out.println(reverse(a));
    }
}
