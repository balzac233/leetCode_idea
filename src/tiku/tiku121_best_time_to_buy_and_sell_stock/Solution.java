package tiku.tiku121_best_time_to_buy_and_sell_stock;

/**
 * @author 001acer8300
 */
public class Solution {

    public static void main(String[] args) {
        // expect value = 5;
        int[] prices = new int[]{7,1,5,3,6,4};

        System.out.println(" result =   "+maxProfit3(prices));

    }

//    /**
//     * v2 去掉注释
//     * @param prices
//     * @return
//     */
//    public static int maxProfit4(int[] prices) {
//        int len = prices.length;
//        int res= 0;
//        for (int i=1;i<len;i++){
//            prices[i-1] = Math.min(prices[i-1],prices[i]);
//            res = Math.max(res,prices[i]-prices[i-1]);
//        }
//        return res;
//    }

    /**
     * v2 去掉注释
     * @param prices
     * @return
     */
    public static int maxProfit3(int[] prices) {
        int len = prices.length;
        int min = prices[0];
        int res= 0;
        for (int i=1;i<len;i++){
            min = Math.min(min,prices[i]);
            res = Math.max(res,prices[i]-min);
        }
        return res;
    }

    /**
     * v2 去掉注释
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
        int len = prices.length;
        if (len<=1){
            return 0;
        }
        int[] dp = new int[len];
        dp[0] = prices[0];
        int res= 0;
        for (int i=1;i<len;i++){
            dp[i] = Math.min(dp[i-1],prices[i]);
            res = Math.max(res,prices[i]-dp[i]);
        }
        return res;
    }

    public static int maxProfit(int[] prices) {

        int len = prices.length;
        if (len<=1){
            return 0;
        }

//        int[][] dp = new int[len][2];
//        dp[0][0] = prices[0];
//        dp[0][1] = prices[0];

        int[] dp = new int[len];
        dp[0] = prices[0];
        int res= 0;

        for (int i=1;i<len;i++){

            dp[i] = Math.min(dp[i-1],prices[i]);

//            if (prices[i]<=dp[i-1][0]){
//                dp[i][0] = prices[i];
//            }else if (prices[i]>=dp[i-1][1]){
//                dp[i][1] = prices[i];
//            }

            res = Math.max(res,prices[i]-dp[i]);

        }

        return res;

    }

}
