package tiku.tiku118_pascals_triangle;

import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @author: lvhengce
 * @create: 2021-08-28
 **/
public class Solution {

    public static void main(String[] args) {

        int numRows = 5;
        System.out.println(generate(numRows));


    }

    public static List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return null;
        }
        List<Integer> t1 = new ArrayList<>();
        List<Integer> t2 = new ArrayList<>();
        t1.add(1);
        t2.add(1);
        t2.add(1);
        List<List<Integer>> res = new ArrayList<>();
        res.add(t1);
        if (numRows == 1) {
            return res;
        }
        res.add(t2);
        if (numRows == 2) {
            return res;
        }

        for (int i=2;i<numRows;i++){
            List<Integer> tmp = new ArrayList<>();
            List<Integer> pre = res.get(i-1);
            tmp.add(1);
            for (int j=1;j<=i-1;j++){
                tmp.add(pre.get(j-1)+pre.get(j));
            }
            tmp.add(1);
            res.add(tmp);
        }
        return res;
    }

}
