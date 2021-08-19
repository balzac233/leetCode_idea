package tiku.tiku_55_jump_game;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 这题叫跳跃游戏，其实和坐公交车之类的路线题，都很像
 * (打脸了)，和公交车略有不同，公交车需要考虑正行逆行，相当于广度搜索。
 * 而跳跃游戏，尽管往前走就行，而且可以选择步数。
 * 有一句非常关键的话，只要你能走到一个最远的地方，那么前面的地方都能走到
 * @author 001acer8300
 */
public class Solution {


    public static void main(String[] args) {

//        输入：nums = [2,3,1,1,4]
//        输出：true

//        输入：nums = [3,2,1,0,4]
//        输出：false

//        int[] arr = new int[]{2,3,1,1,4}; // true
//        int[] arr = new int[]{3,2,1,0,4}; // false
//        int[] arr = new int[]{0}; // false
        int[] arr = new int[]{3,2,2,0,4}; // false



        System.out.println(" res =   "+canJump3(arr));

    }

//    大佬的两句话解法
//    他也不是直接跨步就走，他是走一步看一步，记录最远到达的距离
    public static boolean canJump3(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
//            如果前面那个i达到最远的位置到不了新一轮的i
//            其实也就是那个位置是0.那么就
            if (i > k) {
                return false;
            }
//            这句话表达的就是：k是记录当前这个i位置所能达到的最远的位置
            k = Math.max(k, i + nums[i]);
        }
        return true;
    }


    public static boolean canJump2(int[] nums) {
        int len = nums.length;
        if (len <=0){
            return false;
        }
        if (nums.length ==1){
            return true;
        }
//         passed by 走过的路，避免重复走路
        Set psd = new HashSet();
//        记录可以去的地方（的下标）
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (queue.size()>0){
            int size = queue.size();
            for (int i=0;i<size;i++){
                int num = queue.poll();
                for (int j=1;j<=nums[num];j++){
                    int tmp = num+j;
                    if (tmp == len-1){
                        return true;
                    }
                    if (!psd.contains(tmp)){
                        queue.offer(tmp);
                        psd.add(tmp);
                    }
                }
            }
        }
        return false;
    }


//   v1 用时   内存    7    5 、又慢内存消耗又大
    public static boolean canJump(int[] nums) {
            int len = nums.length;
            if (len <=0){
                return false;
            }
            if (nums.length ==1){
                return true;
            }
//         passed by 走过的路，避免重复走路
        Set psd = new HashSet();
//        记录可以去的地方（的下标）
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (queue.size()>0){
            int size = queue.size();
            for (int i=0;i<size;i++){
                int num = queue.poll();
                if (nums[num] == 0){
                    continue;
                }
                for (int j=1;j<=nums[num];j++){
                    int tmp = num+j;
                    if (tmp == len-1){
                        return true;
                    }
                    if (!psd.contains(tmp)){
                        queue.offer(tmp);
                        psd.add(tmp);
                    }
                }
            }
        }
        return false;
    }
}
