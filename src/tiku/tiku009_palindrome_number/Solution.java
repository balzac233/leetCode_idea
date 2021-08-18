package tiku.tiku009_palindrome_number;

public class Solution {

    public static void main(String[] args) {

//        输入：x = 121
//        输出：true
//        int x= 121;
        int x= 1652561;
//        int x= -1652561;
//

        System.out.println(" result =  "+isPalindrome2(x));

        // test efficiency
        long start = System.currentTimeMillis();
        for (int i=0;i<10000000;i++){
            isPalindrome(x);
        }
        System.out.println(" 测试上面那个函数一千万遍用的毫秒数 "+(System.currentTimeMillis()-start));

                // test efficiency
        long start2 = System.currentTimeMillis();
        for (int i=0;i<10000000;i++){
            isPalindrome2(x);
        }
        System.out.println(" 测试上面那个函数一千万遍用的毫秒数 "+(System.currentTimeMillis()-start2));

    }

    /**
     * //   v2 反转数字的方式
     * //    用字符串来非常占内存又很慢，可以试着反转数字，如果反转后也和原数组一样那么就没问题
     * @param x
     * @return
     */
    public static boolean isPalindrome2(int x) {
        int x3 = x;
        if (x<0){
            return false;
        }
        int x2 = 0;
        while (x>0){
            int tmp = x%10;
            x = x/10;
            x2 = x2*10 + tmp;
        }
        if (x3==x2){
            return true;
        }else {
            return false;
        }
    }

    /**
     * //    用字符串来非常占内存又很慢，可以试着反转数字，如果反转后也和原数组一样那么就没问题
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {

        String a = ""+x;
        int l = 0;
        int r = a.length()-1;
        while (l<r){
            if (a.charAt(l) == a.charAt(r)){
                l++;
                r--;
            }else {
                return false;
            }
        }
        return true;
    }


}
