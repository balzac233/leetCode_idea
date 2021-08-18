package tiku.tiku848_shifting_letters;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
////         expect output 输出："rpl"
//        String s = "abc";
//        int[] shifts = new int[]{3,5,9};

////        expect output  "rul"
//        String s = "ruu";
//        int[] shifts = new int[]{26,9,17};

//        expect output "wqqwlcjnkphhsyvrkdod"
        String s = "mkgfzkkuxownxvfvxasy";
        int[] shifts = new int[]{505870226,437526072,266740649,224336793,532917782,311122363,567754492,595798950,
                81520022,684110326,137742843,275267355,856903962,148291585,919054234,467541837,622939912,116899933,
                983296461,536563513};

        System.out.println(shiftingLetters2(s,shifts));
    }

    //    v2 no note  不要shift2了
    public static String shiftingLetters5(String s, int[] shifts) {
        int len = shifts.length;
        char[] chars = s.toCharArray();
        chars[len-1] = (char) (( (chars[len-1] - 'a') + shifts[len-1] )%26 +'a');
        for (int i=len-2;i>=0;i--){
            shifts[i] = (shifts[i] + shifts[i+1]) %26;
            chars[i] = (char) (( (chars[i] - 'a') + shifts[i] )%26 +'a');
        }
        return String.valueOf(chars);
    }

    //    v4 no note
    public static String shiftingLetters4(String s, int[] shifts) {
        int len = shifts.length;
        char[] chars = s.toCharArray();
//        chars[len-1] = (char) (( (chars[len-1] - 'a') + shifts[len-1] )%26 +'a');
        for (int i=len-2;i>=0;i--){
            shifts[i] = (shifts[i] + shifts[i+1]) %26;

//            chars[i] = (char) (( (chars[i] - 'a') + shifts[i] )%26 +'a');
        }

        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) ((chars[i] - 'a' + shifts[i]) % 26 + 'a');
        }



        return String.valueOf(chars);
    }

    //    v2 no note  不要shift2了
    public static String shiftingLetters3(String s, int[] shifts) {
        int len = shifts.length;
//        int step = 0;
        char[] chars = s.toCharArray();
        chars[len-1] = (char) (( (chars[len-1] - 'a') + shifts[len-1] )%26 +'a');
        for (int i=len-2;i>=0;i--){

//            shifts[i] = shifts[i] + step;
//            shifts[i] = shifts[i] % 26;
//            step = shifts[i];

            shifts[i] = (shifts[i] + shifts[i+1]) %26;

            chars[i] = (char) (( (chars[i] - 'a') + shifts[i] )%26 +'a');
        }



        return String.valueOf(chars);
    }


//    v2 no note
    public static String shiftingLetters2(String s, int[] shifts) {
        int len = shifts.length;
        int[] shift2 = new int[len];
        int step = 0;
        for (int i=len-1;i>=0;i--){
            shift2[i] = shifts[i] + step;
            shift2[i] = shift2[i] % 26;
            step = shift2[i];
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < len; i++) {
            chars[i] = (char) (( (chars[i] - 'a') + shift2[i] )%26 +'a');
        }
        return String.valueOf(chars);
    }

    public static String shiftingLetters(String s, int[] shifts) {
        int len = shifts.length;
        int[] shift2 = new int[len];
        int step = 0;
        for (int i=len-1;i>=0;i--){
            shift2[i] = shifts[i] + step;
            step = shift2[i];
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < len; i++) {

//            int a = chars[i];
//            int b = shift2[i];
////            int c = 'a';// 97
//            int d = (chars[i] + shift2[i] - 'a') % 26 ;
//            int e =  ( (chars[i] - 'a') + shift2[i] )%26 +'a';
//            char e2 = (char)e;
////            int e = (chars[i] - 'a') ;
//            System.out.println(" a = "+a+" b = "+b+" d = "+d+" e = "+e+" e2 = "+e2);
//
//            chars[i] = (char) ( (chars[i] + shift2[i] - 'a') % 26);

            chars[i] = (char) (( (chars[i] - 'a') + shift2[i] )%26 +'a');

////             早期版本
//            chars[i] = (char) (chars[i] + shift2[i] % 26);
        }
        return String.valueOf(chars);
    }

}
