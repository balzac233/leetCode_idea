package tiku.tiku066_plus_one;

public class Solution {

    public static void main(String[] args) {

//        int[] digits = new int[]{1,2,3}; // expect 输出：[1,2,4]
//        int[] digits = new int[]{1,2,3}; // expect [4,3,2,2]
//        // expect [1,3,0]
//        int[] digits = new int[]{1,2,9};
        // expect [1,0]
        int[] digits = new int[]{9};

        System.out.println("  result is :  "+plusOne(digits));

        int[] result = plusOne(digits);
        for (int i = 0; i < result.length; i++) {
            System.out.print("  "+result[i]);
        }

    }

    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        int flag = 1;
        for (int i=0;i<digits.length;i++){
            if (digits[i]!=9){
                flag = 0;
                break;
            }
        }
        int[] res;
        if (flag==1){
            res = new int[len+1];
            res[0] = 1;
            return res;
        }else {
            res = new int[len];
        }
        int addFlag=1;
        for (int i=len-1;i>=0;i--){
            int tmp = digits[i]+addFlag;
            if (tmp >=10){
                addFlag = 1;
                tmp = 0;
            }else {
                addFlag= 0;
            }
            res[i] = tmp;
        }
        return res;
    }

}
