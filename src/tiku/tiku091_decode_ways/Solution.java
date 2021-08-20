package tiku.tiku091_decode_ways;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @description
 * @author: lvhengce
 * @create: 2021-08-20
 **/
public class Solution {

    public static void main(String[] args) {

//        expect value 2
        String s= "12";

//        exptct value 3
//        String s = "226";

        System.out.println("res is =  "+numDecodings(s));


    }

    public static int numDecodings(String s) {
        s = s+"0";
        Queue<Integer> queue = new LinkedList<>();
        String[] tmp = s.split("");
        int res=0;
        int len = tmp.length-1;
        if (len==1){
            return 0;
        }
        if ( "0".equals( tmp[1])){
            return 0;
        }else {
            queue.add(1);
        }
        if ( Integer.parseInt (tmp[0]+tmp[1]) <= 26 ){
            queue.add(2);
        }

//        记录当前编码的可能性所在的下标。例如216，有可能第一位编码是2所在的b，那开始下标移动到1继续判断，也有可能是22，然后开始下标移动到2，也就是从数字6开始。



        while (queue.size()>0){
            int size=  queue.size();
            for (int i=0;i<queue.size();i++){
                int index = queue.poll();
//                如果已经走到了最后一位，说明是其中一种序列
                if (index >= len){
                    if (index==len){
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
