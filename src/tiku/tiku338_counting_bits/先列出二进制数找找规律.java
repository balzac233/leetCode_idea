package tiku.tiku338_counting_bits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 先列出二进制数找找规律 {

    public static void main(String[] args) {

//        double

        for(int i=0;i<32;i++){

            int j=i;

            List<Integer> list = new ArrayList<>();

            while (j>0){
                list.add(j%2);
                j = j/2;
            }

            while (list.size()<5){
                list.add(0);
            }

            Collections.reverse(list);
            for (Integer x:list){
                System.out.print(" "+x);
            }

            System.out.println(" == "+i);

        }


    }

    public static double log2(double n){

        return Math.log(n)/Math.log(2);

    }

//             0 0 0 0 0 == 0
//             0 0 0 0 1 == 1
//             0 0 0 1 0 == 2
//             0 0 0 1 1 == 3
//             0 0 1 0 0 == 4
//             0 0 1 0 1 == 5
//             0 0 1 1 0 == 6
//             0 0 1 1 1 == 7
//             0 1 0 0 0 == 8
//             0 1 0 0 1 == 9
//             0 1 0 1 0 == 10
//             0 1 0 1 1 == 11
//             0 1 1 0 0 == 12
//             0 1 1 0 1 == 13
//             0 1 1 1 0 == 14
//             0 1 1 1 1 == 15
//             1 0 0 0 0 == 16
//             1 0 0 0 1 == 17
//             1 0 0 1 0 == 18
//             1 0 0 1 1 == 19
//             1 0 1 0 0 == 20
//             1 0 1 0 1 == 21
//             1 0 1 1 0 == 22
//             1 0 1 1 1 == 23
//             1 1 0 0 0 == 24
//             1 1 0 0 1 == 25
//             1 1 0 1 0 == 26
//             1 1 0 1 1 == 27
//             1 1 1 0 0 == 28
//             1 1 1 0 1 == 29
//             1 1 1 1 0 == 30
//             1 1 1 1 1 == 31
//
//    Process finished with exit code 0

//    规律， 以  1 、 2 、4 、8 、16 、32 为节点
//    例如8以内的6  是110   ，那么6+8一定是110前面多个1。
//    例如  8-16之间的11，11二进制是1011 ，那么11+16的27一定比11的二进制前面多一个1
//    这个初始化可以先初始化到4，5就可以用这个规律了，5肯定比5-4的1，多一位
//    6比2多一个1，7比3多一个1。每次到2的幂次数时，那么就是1。


}
