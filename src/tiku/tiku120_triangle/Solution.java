package tiku.tiku120_triangle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 001acer8300
 */
public class Solution {

    public static void main(String[] args) {

//        2
//        3 4
//        6 5 7
//        4 1 8 3
//        expect value  自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
//        int[][] triangle = new int[][]{{2},{3,4},{6,5,7},{4,1,8,3}};


//        expect value = -1
        int[][] triangle = new int[][]{{-1},{2,3},{1,-1,-3}};


        List<List<Integer>> lists = new ArrayList<>();
        for (int i=0;i<triangle.length;i++){
            List<Integer> list = new ArrayList<>();;
            for (int j=0;j<triangle[i].length;j++){
                list.add(triangle[i][j]);
            }
            lists.add(list);
        }

        System.out.println("  result is   "+minimumTotal2(lists));

    }

    public static int minimumTotal2(List<List<Integer>> triangle) {
        int len = triangle.size();

        int[][] dp=  new int[len][len];


        Queue<Integer> queue = new LinkedList<>();
        int index=0;
        queue.add(triangle.get(0).get(0));
        int res = Integer.MAX_VALUE;

        while (queue!=null && index <len -1){
            int size = queue.size();
            System.out.println(" size =  "+size);
            for (int i=0;i<size;i++){
                int num = queue.poll();
                System.out.print(num+"\t ");
//              测试   System.out.println(" triangle.get(index).size(); is  "+triangle.get(index).size());
                for (int j=0;j<triangle.get(index).size();j++){
                    queue.add(num + triangle.get(index+1).get(j));
                    queue.add(num + triangle.get(index+1).get(j+1));
                }

            }
            System.out.println("");
            index ++;
        }

        while (queue.size()>0){
////            原来的
//            res = Math.min(queue.poll(),res);
            int num = queue.poll();
            System.out.print(num+"\t ");
            res = Math.min(num,res);

        }
        System.out.println("");
        return res;
    }

//    public static int minimumTotal(List<List<Integer>> triangle) {
////        {{-1},{2,3},{1,-1,-3}};
////        -1,2
////
//        int len = triangle.size();
//        Queue<Integer> queue = new LinkedList<>();
//        int index=0;
//        queue.add(triangle.get(0).get(0));
//        int res = Integer.MAX_VALUE;
//
//        while (queue!=null && index <len -1){
//            int size = queue.size();
//            System.out.println(" size =  "+size);
//            for (int i=0;i<size;i++){
//                int num = queue.poll();
//                System.out.print(num+"\t ");
////              测试   System.out.println(" triangle.get(index).size(); is  "+triangle.get(index).size());
//                for (int j=0;j<triangle.get(index).size();j++){
//                    queue.add(num + triangle.get(index+1).get(j));
//                    queue.add(num + triangle.get(index+1).get(j+1));
//                }
//
//            }
//            System.out.println("");
//            index ++;
//        }
//
//        while (queue.size()>0){
//////            原来的
////            res = Math.min(queue.poll(),res);
//            int num = queue.poll();
//            System.out.print(num+"\t ");
//            res = Math.min(num,res);
//
//        }
//        System.out.println("");
//        return res;
//    }

}
