public class new21 {
    private static int[][] dp;
    public static double new21Game(int N, int K, int W) {
        //dp[i][j]          抽j张牌，这些牌的面值和到了i有多少种情况
        dp = new int[K + W][K+1];
        dp[0][0] = 1;                                      //初始化的情况：没有牌，手中的值为0，这种情况的个数为1

        for(int i = 1; i <= K; i++){                       //抽卡的次数（如果每次都抽到1，那么可能会抽17次）

            for(int val = 1; val <= K-1+W; val++){         //可能出现的值（抽牌后手中可能会出现的值）

                for(int j = 1; j <= W; j++){               //可能会抽出的值

                    if(val - j<K&&val - j>=0) {
                                //停止抽牌的条件
                        //抽当前的牌不能达到val的情况
                        dp[val][i] += dp[val - j][i - 1];
                    }

                }
            }
        }
        //统计分子和分母
        double z = 0;
        double m = 0;
        //在K点之后出现的值统计下来
        for(int i = K; i < K+W; i++){
                    for(int j = 0; j <= K; j++){
                        if(i <= N){
                    z += dp[i][j];
                    System.out.println("z:"+z);
                }
                m += dp[i][j];
                System.out.println(m);
            }
        }


        return z/m;
    }

    public static void main(String[] args) {
        //21点，在17点后停止抽牌， 获胜的概率，每张牌的面值在[1 到 10]之间
        double s=new21Game(21, 17, 10);
        System.out.println("s:"+s);
    }
}
