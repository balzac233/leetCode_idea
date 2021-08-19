package tiku.tiku338_counting_bits;

public class Solution {


    public static void main(String[] args) {

//        测试
//        int x1 = 17;
//        System.out.println(" log2("+x1+")  is  "+ (int)Math.ceil( log2(x1) ) );

//        expect value
//        输入: 2
//输出: [0,1,1]
//        0 0  1
//        int a = 2;


        //        expect value
//        输入: 5
//        输出: [0,1,1,2,1,2]
        //        0 0  1
//        int a = 5;


        //  expect value  [0,1,1,2,1,2,2,3,1]
        int a = 8;
        int[] res = countBits3(a);
        for (int i:res){
            System.out.println(" "+i);
        }
    }
    /**
     * 算出log2(N)
     * @param n
     * @return
     */
    public static double log2(double n){
        return Math.log(n)/Math.log(2);
    }

    //   v4  第一个版本耗时太久，所以不要了   用时 和 内存   100 74
    public static int[] countBits5(int n)  {
        if (n<=1){
            if (n==0){
                return new int[]{0};
            }
            if (n==1){
                return new int[]{0,1};
            }
        }
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        int flag = 2;
        for (int i=2;i<=n;i++){
            if ( ( i & i-1) == 0){
                dp[i] = 1;
                flag = i;
            }else {
                dp[i] = dp[i-flag]+1;
            }
        }
        return dp;
    }

    //   v4  第一个版本耗时太久，所以不要了   用时 和 内存   100 74
    public static int[] countBits4(int n)  {
//        放在一起节省时间，不用走两个if
        if (n<=1){
            if (n==0){
                return new int[]{0};
            }
            if (n==1){
                return new int[]{0,1};
            }
        }
//        int[] res = new int[n+1];
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
//        int tmp = 0;
//        【【【【【【【【这个flag是重点】】】】】】】
        int flag = 2;
//        每次到8,16这种，减下标的操作算一次就行，后面可以重复利用
        for (int i=2;i<=n;i++){
//            tmp = i & i-1;
//            if ( tmp == 0){
            if ( ( i & i-1) == 0){
                dp[i] = 1;
                flag = i;
            }else {
//                7  =  3
//                dp[i] = dp [i-(int) Math.pow(2,Math.floor(log2(i)))]+1;
                dp[i] = dp[i-flag]+1;
            }

        }


        return dp;
    }


    //   v3  第一个版本耗时太久，所以不要了   用时 和 内存   9   42  （还是太慢）
    public static int[] countBits3(int n)  {
//        放在一起节省时间，不用走两个if
        if (n<=1){
            if (n==0){
                return new int[]{0};
            }
            if (n==1){
                return new int[]{0,1};
            }
        }
//        int[] res = new int[n+1];
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
//        int tmp = 0;
        int flag = 2;
//        每次到8,16这种，减下标的操作算一次就行，后面可以重复利用
        for (int i=2;i<=n;i++){
//            tmp = i & i-1;
//            if ( tmp == 0){
            if ( ( i & i-1) == 0){
                dp[i] = 1;
                flag = i;
            }else {
//                7  =  3
//                dp[i] = dp [i-(int) Math.pow(2,Math.floor(log2(i)))]+1;
                dp[i] = dp[i-flag]+1;
            }

        }


        return dp;
    }

//   v2  第一个版本耗时太久，所以不要了   用时 和 内存   9   42  （还是太慢）
        public static int[] countBits2(int n)  {
//        放在一起节省时间，不用走两个if
        if (n<=1){
            if (n==0){
                return new int[]{0};
            }
            if (n==1){
                return new int[]{0,1};
            }
        }
//        int[] res = new int[n+1];
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
//        int tmp = 0;
        for (int i=2;i<=n;i++){
//            tmp = i & i-1;
//            if ( tmp == 0){
            if ( ( i & i-1) == 0){
                dp[i] = 1;
            }else {
//                7  =  3
                dp[i] = dp [i-(int) Math.pow(2,Math.floor(log2(i)))]+1;
            }

        }


        return dp;
    }

//   v1  用时，内存   9%   74%
    public static int[] countBits(int n) {
        if (n==0){
            return new int[]{0};
        }
        if (n==1){
            return new int[]{0,1};
        }

//        int[] res = new int[n+1];

        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        int tmp = 0;
        for (int i=2;i<=n;i++){
            tmp = i & i-1;
            if ( tmp == 0){
                dp[i] = 1;
            }else {
//                7  =  3
                dp[i] = dp [i-(int) Math.pow(2,Math.ceil(log2(i))-1)]+1;
            }

        }


        return dp;
    }



}
