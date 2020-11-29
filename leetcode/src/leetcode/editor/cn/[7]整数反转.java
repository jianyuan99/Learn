//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 示例 1: 
//
// 输入: 123
//输出: 321
// 
//
// 示例 2: 
//
// 输入: -123
//输出: -321
// 
//
// 示例 3: 
//
// 输入: 120
//输出: 21
// 
//
// 注意: 
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 
// Related Topics 数学 
// 👍 2291 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
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
            if((a*Math.pow(10,n)>Math.pow(2,31)-1)&&(a*Math.pow(10,n)<(Math.pow(-2,31)))){
                return 0;
            }
            else if((s<(Math.pow(2,31)-a*Math.pow(10,n)-1))&&(s>(Math.pow(-2,31)-a*Math.pow(10,n)))) {
                s += a * Math.pow(10, n);
                n--;
            }
            else{
                return 0;
            }
        }
        return s;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
