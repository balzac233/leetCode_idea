package tiku.tiku552_student_attendance_record_ii;

import java.util.Arrays;
import java.util.stream.LongStream;

public class Solution {

    public static int MOD = 1000000007;

    public static void main(String[] args) {



    }



    public static int checkRecord(int n) {
//        先试着分两种情况来解，假设没有缺勤记录。
//        int[] res = new int[n];
        final int MOD = 1000000007;
//        因为每次基本只用得着前一天的数据，可以试着用 int[2][2][3]; 来替换 int[n+1][2][3]; 数据用完覆盖就行
//        或者用两个int[2][3];   官方第二个解法用的就是 dp 和 dpNew 这两个二维数组
        int[][][] dp = new int[n+1][2][3];
        dp[0][0][0] = 0;


//        'A'：Absent，缺勤       'L'：Late，迟到           'P'：Present，到场
         for (int i = 1; i <= n; i++) {
            // 以 P 结尾的数量(今天不缺勤)
            // 之前的数据有缺勤0次和1次的情况
            for (int j = 0; j <= 1; j++) {

                for (int k = 0; k <= 2; k++) {
                    //                无论是连续几天迟到，第i天，连续迟到天数肯定变为为0，而缺勤次数不变
                    dp[i][j][0] = (dp[i][j][0] + dp[i - 1][j][k]) % MOD;
                }
            }
            // 以 A 结尾的数量   （今天缺勤了）
            for (int k = 0; k <= 2; k++) {
//                因为缺勤，第i天只有缺勤一次的情况了，dp[i][0][0] 这种不存在 ， dp[i][1][0] 需要计算
//                因为今天缺勤，缺勤次数只能为1了，不需要加上昨天也缺勤的情况，只能加上昨天没缺勤（迟到次数3天以内）的情况，共三种，
                dp[i][1][0] = (dp[i][1][0] + dp[i - 1][0][k]) % MOD;
            }
            // 以 L 结尾的数量
//             计算缺勤为0，1的
            for (int j = 0; j <= 1; j++) {
//                既然第i天迟到，那么迟到次数肯定只有1和2
                for (int k = 1; k <= 2; k++) {
//                    假设第i天缺勤j次迟到k次，那么这种情况的数量要加上前一天缺勤少一次的情况。
                    dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j][k - 1]) % MOD;
                }
            }
        }
        int sum = 0;
//         最后累加第n天的这六种情况
//        其中缺勤天数 0 或者 1，   最近三天的迟到次数 0 ， 1 ， 2
        for (int j = 0; j <= 1; j++) {
            for (int k = 0; k <= 2; k++) {
                sum = (sum + dp[n][j][k]) % MOD;
            }
        }
        return sum;

    }

    // 方法六、动态规划 + 滚动数组
    public int checkRecord2v1(int n) {
        long[][] dp = new long[2][6];
        // 初始值
        dp[0][0] = 1;
        dp[0][1] = 1;
        dp[0][3] = 1;

        for (int i = 1; i < n; i++) {
            // 当前使用的下标
            int cur = i & 1;
            // 上一次使用的下标
            int last = (i - 1) & 1;
            dp[cur][0] = (dp[last][0] + dp[last][1] + dp[last][2]) % MOD;
            dp[cur][1] = dp[last][0];
            dp[cur][2] = dp[last][1];
            dp[cur][3] = (dp[last][3] + dp[last][4] + dp[last][5] + dp[last][0] + dp[last][1] + dp[last][2]) % MOD;
            dp[cur][4] = dp[last][3];
            dp[cur][5] = dp[last][4];
        }

        return (int) (LongStream.of(dp[(n - 1) & 1]).sum() % MOD);
    }


    //    官方时间复杂度为O(log n)的解法






    public int checkRecordO(int n) {
//        因为缺勤总天数和最近连续迟到天数的情况只有6种。
//        所以 缺勤次数j（只有0和1）， 迟到次数k（情况有 0 ，1 ，2），可以转换为
//          j*3 + k  ，例如 4 ，就是缺勤1天，迟到1天 k*2 + j 这种应该也行，结果不重复的

//      【【假设】】 行就是昨天的缺勤天数和最近连续迟到天数，缺勤 a ， 迟到 l  到场 p
//      {1, 1, 0, 1, 0, 0},   代表 {l0a0,l1a0,l2a0,l0a1，l1a1，l2a1}
//        假设列是今天的缺勤和迟到（不知道课本学的矩阵和计算机的列，下标顺序是从上到下还是从下到上）
//       【【假设】】 从上到下为 0 - 5 {l0a0,l1a0,l2a0,l0a1，l1a1，l2a1}
//        照理，某天缺勤0迟到0，也就是 l0a0，那么所有行或者所有列都是同一个数字，这个矩阵不符。应该不是这个含义。

//        这里的i据说指的是前i天，所以列才是代表缺勤和迟到的情况。，行是前面一天
////    dp[i][0]=dp[i−1][0]+dp[i−1][1]+dp[i−1][2]
////    dp[i][1]=dp[i−1][0]
////    dp[i][2]=dp[i−1][1]
////    dp[i][3]=dp[i−1][0]+dp[i−1][1]+dp[i−1][2]+dp[i−1][3]+dp[i−1][4]+dp[i−1][5]
////    dp[i][4]=dp[i−1][3]
////    dp[i][5]=dp[i−1][4]

//      如果今天是 0 也就是 l0a0 ，无迟到无缺勤 ，那么加上前一天的0情况，1情况和2情况
////    dp[i][0]=dp[i−1][0]+dp[i−1][1]+dp[i−1][2]

////    dp[i][1]=dp[i−1][0]
////    dp[i][2]=dp[i−1][1]

//        3是今天已经缺勤的意思
////    dp[i][3]=dp[i−1][0]+dp[i−1][1]+dp[i−1][2]+dp[i−1][3]+dp[i−1][4]+dp[i−1][5]
////    dp[i][4]=dp[i−1][3]
////    dp[i][5]=dp[i−1][4]

        long[][] mat = {
            {1, 1, 0, 1, 0, 0},
            {1, 0, 1, 1, 0, 0},
            {1, 0, 0, 1, 0, 0},
            {0, 0, 0, 1, 1, 0},
            {0, 0, 0, 1, 0, 1},
            {0, 0, 0, 1, 0, 0}
        };
        long[][] res = pow(mat, n);
        long sum = Arrays.stream(res[0]).sum();
        return (int) (sum % MOD);
    }

    public long[][] pow(long[][] mat, int n) {
        long[][] ret = {{1, 0, 0, 0, 0, 0}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, mat);
            }
            n >>= 1;
            mat = multiply(mat, mat);
        }
        return ret;
    }

    public long[][] multiply(long[][] a, long[][] b) {
        int rows = a.length, columns = b[0].length, temp = b.length;
        long[][] c = new long[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                for (int k = 0; k < temp; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                    c[i][j] %= MOD;
                }
            }
        }
        return c;
    }



}
