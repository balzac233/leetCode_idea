package tiku.tiku881_boats_to_save_people;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description
 * @author: lvhengce
 * @create: 2021-08-26
 **/
public class Solution {

    public static void main(String[] args) {

//        int[] people = new int[]{2,3,2,1};
//        int limit = 3;
////        3

//        int[] people = new int[]{2,1};
//        int limit = 3;
////        1

//        int[] people = new int[]{3,5,3,4};
//        int limit = 5;
////        4

//        int[] people = new int[]{5, 1, 4, 2};
//        int limit = 6;
//////        2

//        int[] people = new int[]{3,1,6,7,5};
//        int limit = 7;
//////        4


        int[] people = new int[]{3, 8, 4, 9, 2, 2, 7, 1, 6, 10, 6, 7, 1, 7, 7, 6, 4, 4, 10, 1};
        int limit = 10;
//        4

        System.out.println(numRescueBoats3(people, limit));

    }

//    v3 在v1的基础上改思路，优化
    public static int numRescueBoats3(int[] people, int limit) {


        int len = people.length;
        if (len == 0){
            return 0;
        }

//        ArrayList<Integer> p = new ArrayList<>();
//        for (int i = 0; i < len - 1; i++) {
//            p.add(people[i]);
//        }
        Arrays.sort(people);
        int res = 0;
        int l = 0;
        int r = len-1;
        while (l<r){
//            if ( p.get(r)+p.get(l)<=limit){
            if ( people[r]+people[l]<=limit){
                r--;
                l++;
                res++;
            }
            else{
                r--;
                res++;
            }
        }
        if (l==r){
            res++;
        }
        return res;
    }

//   确定数组中的最大值，如果就是limit，进入二分查找，
//    但是此时需要知道第二大的值。
    public static int numRescueBoats2(int[] people, int limit) {
        int len = people.length + 1;
        int limit2 = limit - 1;
        int res = 0;
        if (len == 0) {
            return 0;
        }
        ArrayList<Integer> p = new ArrayList<>();

//        v2
        for (int i = 0; i < len - 1; i++) {
            p.add(people[i]);
        }
        //v2
        p.add(Integer.MAX_VALUE);
        Collections.sort(p);
//        for (int i=0;i>)

        int l = 0;
        // v2
        int r = len - 1;
        int m = 0;
        if (p.get(len - 2) < limit) {
            m = len - 2;
        } else {

            w:
            while (l < r) {
                m = (l + r) / 2;
                if (p.get(m) < limit2) {
                    l = m + 1;
                } else if (p.get(m) > limit2) {
                    r = m - 1;
                } else {
                    // v2
                    for (int i = m; i < len - 1; i++) {
                        if (p.get(i + 1) == limit2) {
                            m = i + 1;
                        } else {
                            break w;
                        }
                    }
                }
            }
//            if ()
        }
//        此时m是最右的等于limit-1的下标（不一定）
        int left = 0;
//        int right = m;
        res = res + (len - 1 - m);
        for (int i = m; i >= left; i--) {
            if (p.get(i) + p.get(left) <= limit) {
                left++;
            }
            res++;
        }
        return res - 1;

    }

//    速度慢，内存占太多
    public static int numRescueBoats(int[] people, int limit) {
        int len = people.length + 1;
        int limit2 = limit - 1;
        int res = 0;
        if (len == 0) {
            return 0;
        }
        ArrayList<Integer> p = new ArrayList<>();

//        v2
        for (int i = 0; i < len - 1; i++) {
            p.add(people[i]);
        }
        //v2
        p.add(Integer.MAX_VALUE);
        Collections.sort(p);
//        for (int i=0;i>)

        int l = 0;
        // v2
        int r = len - 1;
        int m = 0;
        if (p.get(len - 2) < limit) {
            m = len - 2;
        } else {
            w:
            while (l < r) {
                m = (l + r) / 2;
                if (p.get(m) < limit2) {
                    l = m + 1;
                } else if (p.get(m) > limit2) {
                    r = m - 1;
                } else {
                    // v2
                    for (int i = m; i < len - 1; i++) {
                        if (p.get(i + 1) == limit2) {
                            m = i + 1;
                        } else {
                            break w;
                        }
                    }
                }
            }
//              指针太右了没关系，反正匹配不上，比如limit是10,10和1也配不了对，
//            但是如果是指针偏左到9了，那么9可以和1配对却自己一艘船，那么结果就不对了
            while (p.get(m+1)<limit){
                m = m+1;
            }

        }
//        此时m是最右的等于limit-1的下标
        int left = 0;
//        int right = m;
        res = res + (len - 1 - m);
        for (int i = m; i >= left; i--) {
            if (p.get(i) + p.get(left) <= limit) {
                left++;
            }
            res++;
        }
        return res - 1;

    }

}
