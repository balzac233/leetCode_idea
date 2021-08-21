package tiku.tiku091_decode_ways;

import java.time.OffsetDateTime;
import java.util.*;

/**
 * @description
 * @author: lvhengce
 * @create: 2021-08-20
 **/
public class Solution {

    public static void main(String[] args) {

//        expect value 2
//        String s= "12";

//        exptct value 3
        String s = "226";

//        expect val 2
//        String s = "227";

        //        exptct value 0
//        String s = "06";

        //        exptct value 1
//        String s = "10";

//        exptct value 1
//        String s = "1";

//        超时了
//        String s =  "111111111111111111111111111111111111111111111";


        System.out.println("res is =  "+numDecodings2(s));


    }
//    2，动态规划解决
//    定义dp[i]表示前i个字符的解码数。
//    如果要求前i个字符的解码数
//    我们可以先求前i-1个字符的解码数，但前提条件是当前字符也可以解码（一个字符的话，只要不是0，都可以）
//    还可以求前i-2个字符的解码数，但前提条件是当前字符和前一个字符构成的两个数字是有效的。
//    看到这里大家应该已经明白了，如果没有条件限制的话，这题解法和爬楼梯完全一样，递归公式其实就是个斐波那契数列
//    dp[i]=dp[i-1]+dp[i-2]
//    只不过这里都有条件限制，但原理都差不多，我们只需要根据条件来判断哪一项该加，哪一项不该加


    public int numDecodings3(String s) {
        int length = s.length();
        int[] dp = new int[length + 1];
        dp[0] = 1;
        for (int i = 1; i <= length; i++) {
            //判断截取一个是否符合（只要不是0，都符合）
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            }
            //判断截取两个是否符合
            if (i >= 2 && (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[length];
    }

//    3，动态规划代码优化
//    斐波那契数列空间复杂度是可以优化的，只需要两个变量即可，不需要申请一个数组，我们来对着修改一下

    public int numDecodings4(String s) {
        int length = s.length();
        int lastLast = 0;
        int last = 1;
        for (int i = 0; i < length; i++) {
            int cur = 0;
            //判断截取一个是否符合（只要不是0，都符合）
            if (s.charAt(i) != '0') {
                cur = last;
            }
            //判断截取两个是否符合
            if (i >= 1 && (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2' && s.charAt(i) <= '6')) {
                cur += lastLast;
            }
            lastLast = last;
            last = cur;

        }
        return last;
    }


//    由于包含大量的重复计算，直接导致运行超时
//
//    我们可以把计算的结果存到map中（一个数组），下次运算的时候如果map中有就直接从map中取，如果没有在计算，计算之后再把结果存到map中。
//
//    作者：sdwwld
//    链接：https://leetcode-cn.com/problems/decode-ways/solution/shu-ju-jie-gou-he-suan-fa-di-gui-he-dong-pnyf/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    /**
     * @Description 如果字符串是以0结尾的，减掉一种情况就行？
     *              0开头和0结尾的都要特殊处理
     * @param:
     * @return: int
     * @auther: lvhengce
     * @date: 2021/8/21 9:21
     */

    public static int numDecodings2(String s) {
        s = s+"0";
        //        记录当前编码的可能性所在的下标。例如216，有可能第一位编码是2所在的b，那开始下标移动到1继续判断，也有可能是22，然后开始下标移动到2，也就是从数字6开始。
        Queue<Integer> queue = new LinkedList<>();
        String[] tmp = s.split("");
        Map<Integer,int[]> map = new HashMap<>();
        int res=0;
        int len = tmp.length-1;
//        if (len==1){
//            return 0;
//        }
        if ( "0".equals( tmp[0])){
            return 0;
        }else if (len==1){
            return 1;
        }else {
            queue.add(1);
        }
        if ( Integer.parseInt (tmp[0]+tmp[1]) <= 26 ){
            queue.add(2);
        }
        // 开始循环
        while (queue.size()>0){
            int size = queue.size();
            for (int i=0;i<size;i++){
                int index = queue.poll();

                if (map.containsKey(index)){
                    int[] q = map.get(index);
                    for (int j=0;j<q.length;j++){
                        queue.offer(q[j]);
                    }
                }

//                for循环里面这段东西，都可以放map里面
//                如果已经走到了最后一位，说明是其中一种序列
                if (index >= len-1){
                    if (index<=len+1 ){
                        res++;
                    }
                    continue;
                }
//                如果当前位是0，肯定不对了，弃掉就行
                if ("0".equals(tmp[index])){
                    continue;
                }
//                int[] p = new int[2];
                queue.offer(index+1);

                if ( Integer.parseInt (tmp[index]+tmp[index+1]) <= 26 ){
                    queue.add(index+2);
                    map.put(index,new int[]{index+1,index+2});
                }else {
                    map.put(index,new int[]{index+1});
                }



            }
        }
        if ("0".equals( tmp[len-1])){
            res --;
        }

        return res;
    }

    public static int numDecodings(String s) {
        s = s+"0";
        Queue<Integer> queue = new LinkedList<>();
        String[] tmp = s.split("");
        int res=0;
        int len = tmp.length-1;
//        if (len==1){
//            return 0;
//        }
        if ( "0".equals( tmp[0])){
            return 0;
        }else {
            queue.add(0);
        }
        if ( Integer.parseInt (tmp[0]+tmp[1]) <= 26 ){
            queue.add(1);
        }

//        记录当前编码的可能性所在的下标。例如216，有可能第一位编码是2所在的b，那开始下标移动到1继续判断，也有可能是22，然后开始下标移动到2，也就是从数字6开始。



        while (queue.size()>0){
            int size=  queue.size();
            for (int i=0;i<size;i++){
                int index = queue.poll();
//                如果已经走到了最后一位，说明是其中一种序列
                if (index >= len-1){
//                    如果前一位
                    if (index==len-1 && !"0".equals(tmp[index]) ){
                        res++;
                    }
                    continue;
                }
//                如果当前位是0，肯定不对了，弃掉就行
                if ("0".equals(tmp[index])){
                    continue;
                }
                queue.add(index+1);
                if ( Integer.parseInt (tmp[index]+tmp[index+1]) <= 26 ){
                    queue.add(index+2);
                }
            }
        }

        return res;
    }

}
