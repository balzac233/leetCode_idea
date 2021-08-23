package tiku.tiku042_trapping_rain_water;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.REUtil;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @description
 * @author: lvhengce
 * @create: 2021-08-23
 **/
public class Solution {

//    首先，每个下标都是代表柱子，所以不存在一些中空或者其他奇奇怪怪的情况
//    能接住水的条件

    public static void main(String[] args) {
//                      O
//              O       O O   O
//        _ O _ O O _ O O O O O O
//        输出：6
//        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        //        输出：9
//        int[] height = new int[]{4, 2, 0, 3, 2, 5};

        //        输出：2
//        int[] height = new int[]{2,0,2};

//       执行出错了。
        int[] height = new int[]{8,5,4,1,8,9,3,0,0};



        printZ(height);
        System.out.println("  res is   " + trap6(height));

    }

//    官方题解
    public static int trap6(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                ans += leftMax - height[left];
                ++left;
            } else {
                ans += rightMax - height[right];
                --right;
            }
        }
        return ans;
    }



    //  v4   思路1 v2  (试着用递归)
//    找出最高点
//    分别从两边往最高点遍历：如果下一个数比当前数小，说明可以接到水
    public static int trap4(int[] height) {
        int l = 0;
        int r = height.length-1;
        int max = 0;
        int maxIndex = 0;
        int res1 = 0;
        int res2 = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
                maxIndex = i;
            }
        }
        while (l-r>=1){
            for (int i = l; i < r; i++) {
                if (height[i] > max) {
                    max = height[i];
                    maxIndex = i;
                }
            }
            int water = max * (r - maxIndex - 1);
            for (int i = maxIndex + 1; i < r; i++) {
                water = water - height[i];
            }
            r =  maxIndex;
            res1 = res1 + water;
        }
//        res1 = sl(height, l, maxIndex);
//        res2 = sr(height,maxIndex,r);
        return res1+res2;
    }

    //  v5   思路1 v3  (递归成功，试着用while)
//    找出最高点
//    分别从两边往最高点遍历：如果下一个数比当前数小，说明可以接到水
    public static int trap5(int[] height) {
        int len = height.length;
        int l = 0;
        int r = len-1;
        int max = 0;
        int maxIndex = 0;
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
                maxIndex = i;
            }
        }
        int maxIndex2 = maxIndex;
        r=maxIndex2;
        while (r-l>=1){
            max = 0;
            maxIndex = 0;
            for (int i = l; i < r; i++) {
                if (height[i] > max) {
                    max = height[i];
                    maxIndex = i;
                }
            }
            if (max<=0){
                break;
            }
            int water = max * (r - maxIndex - 1);
            for (int i = maxIndex + 1; i < r; i++) {
                water = water - height[i];
            }
            r =  maxIndex;
            res = res + water;
        }
        l = maxIndex2;
        r = height.length-1;
        while (r-l>=1){
            max = 0;
            maxIndex = 0;
            for (int i = l+1; i <= r; i++) {
                if (height[i] > max) {
                    max = height[i];
                    maxIndex = i;
                }
            }
            if (max<=0){
                break;
            }
            int water = max * ( maxIndex-l - 1);
            for (int i = l+1; i < maxIndex; i++) {
                water = water - height[i];
            }
            l =  maxIndex;
            res = res + water;
        }
        return res;
    }



    public static int sl(int[] height, int l, int r) {
        if (r-l<=1){
            return 0;
        }
        int max = 0;
        int maxIndex = 0;
        for (int i = l; i < r; i++) {
            if (height[i] > max) {
                max = height[i];
                maxIndex = i;
            }
        }
        if (max<=0){
            return 0;
        }
        int water = max * (r - maxIndex - 1);
        for (int i = maxIndex + 1; i < r; i++) {
            water = water - height[i];
        }
        r =  maxIndex;
        return water + sl(height,l,r);

    }

    public static int sr(int[] height, int l, int r) {
        if (r-l<=1){
            return 0;
        }
        int max = 0;
        int maxIndex = 0;
        for (int i = l+1; i <= r; i++) {
            if (height[i] > max) {
                max = height[i];
                maxIndex = i;
            }
        }
        if (max<=0){
            return 0;
        }
        int water = max * ( maxIndex-l - 1);
        for (int i = l+1; i < maxIndex; i++) {
            water = water - height[i];
        }
        l =  maxIndex;
        return water+sr(height, l, r);

    }


//    public static int rl(int[] height, int l, int r, int res) {
//        int max = 0;
//        int maxIndex = 0;
//        for (int i = l; i < r; i++) {
//            if (height[i] > max) {
//                max = height[i];
//                maxIndex = i;
//            }
//        }
//        int water = max * (r - max + 1);
//        for (int i = max + 1; i < r; i++) {
//            water = water - height[i];
//        }
//        l = max;
//        return res+water;
//    }

    //    思路1
//    找出最高点
//    分别从两边往最高点遍历：如果下一个数比当前数小，说明可以接到水
    public static int trap3(int[] height) {
//        int l = 0;
        int len = height.length;
        if (len <= 2) {
            return 0;
        }
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
                maxIndex = i;
            }
        }
        for (int i = maxIndex - 1; i >= 0; i--) {

        }
        return 0;
    }

    public static int fmi(int[] height, int l, int r) {
        int max = 0;
        int maxIndex = 0;
        for (int i = l; i < r; i++) {
            if (height[i] > max) {
                max = height[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    //    v2 去掉注释
//    思路1
//    找出最高点
//    分别从两边往最高点遍历：如果下一个数比当前数小，说明可以接到水
    public static int trap2(int[] height) {
        Set<Integer> set = new HashSet<>();
        int len = height.length;
        if (len <= 2) {
            return 0;
        }
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
                maxIndex = i;
            }
        }
        int[] dp = new int[max + 1];
        dp[0] = 0;
        int l = 0;
        int r = len - 1;
        for (int i = 1; i <= max; i++) {
            int num = 0;
            for (int k1 = l; k1 < len; k1++) {
                if (height[k1] >= i) {
                    l = k1;
                    break;
                }
            }
            for (int k2 = r; k2 >= 0; k2--) {
                if (height[k2] >= i) {
                    r = k2;
                    break;
                }
            }
            for (int j = l + 1; j <= r - 1; j++) {
                if (set.contains(j)) {
                    continue;
                }
                if (height[j] >= i) {
                    num++;
                } else {
                    set.add(j);
                }
            }
            int num2;
            if (r - l <= 1) {
                num2 = 0;
            } else {
                num2 = r - l - 1;
            }
            dp[i] = dp[i - 1] + num2 - num;
        }
        return dp[max];
    }

    public static int trap(int[] height) {
        Set<Integer> set = new HashSet<>();
        int len = height.length;
        if (len <= 2) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            max = Math.max(height[i], max);
//            set.add(i);
        }
//        int[][] index = new int[max+1][2];
//        for (int i = 0; i < height.length; i++) {
//            max[i][]
//        }
//        if (max ==0){
//            return 0;
//        }

        int[] dp = new int[max + 1];
        dp[0] = 0;
        int l = 0;
        int r = len - 1;
        for (int i = 1; i <= max; i++) {
//            int tmax = 0;
            int num = 0;
            for (int k1 = l; k1 < len; k1++) {
                if (height[k1] >= i) {
                    l = k1;
                    break;
                }
            }
            for (int k2 = r; k2 >= 0; k2--) {
                if (height[k2] >= i) {
                    r = k2;
                    break;
                }
            }
//            Iterator<Integer> it = set.iterator();
//            while (it.hasNext()){
//                int s = it.next();
//                if (height[s] >= i) {
//                    num++;
//                }else {
//                    it.remove();
//                }
//            }
//            for (int s:set){
//                if (height[s] >= i) {
//                    num++;
//                }else {
//                    set.remove(s);
//                }
//            }
            for (int j = l + 1; j <= r - 1; j++) {
                if (set.contains(j)) {
                    continue;
                }
                if (height[j] >= i) {
                    num++;
                } else {
                    set.add(j);
                }
            }
            int num2;
            if (r - l <= 1) {
                num2 = 0;
            } else {
                num2 = r - l - 1;
            }
            dp[i] = dp[i - 1] + num2 - num;
        }
        return dp[max];
    }

    public static void printZ(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            max = Math.max(height[i], max);
        }
        for (int i = max; i > 1; i--) {
            for (int j = 0; j < height.length; j++) {
                if (height[j] >= i) {
                    System.out.print(" O");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        for (int j = 0; j < height.length; j++) {
            if (height[j] >= 1) {
                System.out.print(" O");
            } else {
                System.out.print(" _");
            }
        }
        System.out.println();
    }

}
