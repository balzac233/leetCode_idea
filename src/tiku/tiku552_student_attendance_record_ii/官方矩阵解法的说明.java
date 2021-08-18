package tiku.tiku552_student_attendance_record_ii;

public class 官方矩阵解法的说明 {

    public static void main(String[] args) {

        //    方法二：矩阵快速幂
//    我们还可以使用矩阵快速幂来求解，该方法可以将方法一的时间复杂度由 O(n)O(n) 降为 O(\log n)O(logn)。
//
//    为了使用矩阵快速幂，需要将方法一的动态规划表示中的 jj 和 kk 合并到一个维度，即动态规划的状态为：\textit{dp}[i][j \times 3 + k]dp[i][j×3+k] 表示前 ii 天有 jj 个 \text{`A'}‘A’ 且结尾有连续 kk 个 \text{`L'}‘L’ 的可奖励的出勤记录的数量，其中 0 \le i \le n0≤i≤n，0 \le j \le 10≤j≤1，0 \le k \le 20≤k≤2，0 \le j \times 3 + k < 60≤j×3+k<6。
//
//    在新的动态规划状态定义下，边界情况是 \textit{dp}[0][0] = 1dp[0][0]=1，当 1 \le i \le n1≤i≤n 时，状态转移方程如下：
//
//            \begin{cases} \textit{dp}[i][0] = \textit{dp}[i - 1][0] + \textit{dp}[i - 1][1] + \textit{dp}[i - 1][2] \\ \textit{dp}[i][1] = \textit{dp}[i - 1][0] \\ \textit{dp}[i][2] = \textit{dp}[i - 1][1] \\ \textit{dp}[i][3] = \textit{dp}[i - 1][0] + \textit{dp}[i - 1][1] + \textit{dp}[i - 1][2] + \textit{dp}[i - 1][3] + \textit{dp}[i - 1][4] + \textit{dp}[i - 1][5] \\ \textit{dp}[i][4] = \textit{dp}[i - 1][3] \\ \textit{dp}[i][5] = \textit{dp}[i - 1][4] \end{cases}
//⎩
//        ⎪
//        ⎪
//        ⎪
//        ⎪
//        ⎪
//        ⎪
//        ⎪
//        ⎪
//        ⎪
//        ⎨
//        ⎪
//        ⎪
//        ⎪
//        ⎪
//        ⎪
//        ⎪
//        ⎪
//        ⎪
//        ⎪
//        ⎧
//        ​
//
//    dp[i][0]=dp[i−1][0]+dp[i−1][1]+dp[i−1][2]
//    dp[i][1]=dp[i−1][0]
//    dp[i][2]=dp[i−1][1]
//    dp[i][3]=dp[i−1][0]+dp[i−1][1]+dp[i−1][2]+dp[i−1][3]+dp[i−1][4]+dp[i−1][5]
//    dp[i][4]=dp[i−1][3]
//    dp[i][5]=dp[i−1][4]
//            ​
//
//
//    令 \textit{dp}[n]dp[n] 表示包含 66 个元素的行向量：
//
//            \textit{dp}[n] = \left[ \begin{matrix} \textit{dp}[n][0] & \textit{dp}[n][1] & \textit{dp}[n][2] & \textit{dp}[n][3] & \textit{dp}[n][4] & \textit{dp}[n][5] \end{matrix} \right]
//    dp[n]=[
    //    dp[n][0]
    //    dp[n][1]
    //    dp[n][2]
    //    dp[n][3]
    //    dp[n][4]
    //    dp[n][5]
//    ]
//
//    我们可以构建这样一个递推关系：
//
//            \textit{dp}[n] = \textit{dp}[n - 1] \times \left[ \begin{matrix} 1 & 1 & 0 & 1 & 0 & 0 \\ 1 & 0 & 1 & 1 & 0 & 0 \\ 1 & 0 & 0 & 1 & 0 & 0 \\ 0 & 0 & 0 & 1 & 1 & 0 \\ 0 & 0 & 0 & 1 & 0 & 1 \\ 0 & 0 & 0 & 1 & 0 & 0 \end{matrix} \right]
//    dp[n]=dp[n−1]×
//            ​
////      1 1 0 1 0 0
////      1 0 1 1 0 0
////      1 0 0 1 0 0
////      0 0 0 1 1 0
////      0 0 0 1 0 1
////      0 0 0 1 0 0
//
//    因此：
//
//            \textit{dp}[n] = \textit{dp}[0] \times \left[ \begin{matrix} 1 & 1 & 0 & 1 & 0 & 0 \\ 1 & 0 & 1 & 1 & 0 & 0 \\ 1 & 0 & 0 & 1 & 0 & 0 \\ 0 & 0 & 0 & 1 & 1 & 0 \\ 0 & 0 & 0 & 1 & 0 & 1 \\ 0 & 0 & 0 & 1 & 0 & 0 \end{matrix} \right]^n
//    dp[n]=dp[0]×
//      1 1 0 1 0 0     (n)
//      1 0 1 1 0 0
//      1 0 0 1 0 0
//      0 0 0 1 1 0
//      0 0 0 1 0 1
//      0 0 0 1 0 0

//
//   令： M = \left[ \begin{matrix} 1 & 1 & 0 & 1 & 0 & 0 \\ 1 & 0 & 1 & 1 & 0 & 0 \\ 1 & 0 & 0 & 1 & 0 & 0 \\ 0 & 0 & 0 & 1 & 1 & 0 \\ 0 & 0 & 0 & 1 & 0 & 1 \\ 0 & 0 & 0 & 1 & 0 & 0 \end{matrix} \right]
//    M=
//      1 1 0 1 0 0
//      1 0 1 1 0 0
//      1 0 0 1 0 0
//      0 0 0 1 1 0
//      0 0 0 1 0 1
//      0 0 0 1 0 0
//
//    因此只要我们能快速计算矩阵 MM 的 nn 次幂，就可以得到 \textit{dp}[n]dp[n] 的值，然后计算可奖励的出勤记录的数量。如果直接求取 M^nM
//            n
// ，时间复杂度是 O(n)O(n)，可以定义矩阵乘法，然后用快速幂算法来加速这里 M^nM
//            n
//    的求取。计算过程中需要将结果对 10^9+710
//            9
//            +7 取模。
//
//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/student-attendance-record-ii/solution/xue-sheng-chu-qin-ji-lu-ii-by-leetcode-s-kdlm/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    }

}
