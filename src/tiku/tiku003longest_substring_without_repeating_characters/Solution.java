package tiku.tiku003longest_substring_without_repeating_characters;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {

        /**
         * 测试stringbuilder的indexof和lastIndexof  ====看能否把字拓展出去
         * 	//		String a = "yypabc";
         * 	//		int b = a.charAt(0);
         * 	//		int c = a.charAt(3);
         * 	//		int d= a.charAt(4);
         * 	//		System.out.println(" a= "+a+" b= "+b+" c= "+c+ " d= "+d);
         * 	//
         * 	//		char a1 = 'Ԭ';
         * 	//		int a2 = a1;
         * 	//		System.out.println(a2);
         *
         * 	//		����  stringbuilder �� delete
         *
         * 	//		StringBuilder sb = new StringBuilder();
         * 	//		sb.append("1");
         * 	//		sb.append("0");
         * 	//		sb.append("9");
         * 	//		sb.append("2");
         * 	//		sb.append("9");
         * 	//		sb.append("1");
         * 	//		sb.append("65");
         * 	//		sb.append("93");
         * 	//		sb.append("y");
         * 	//		sb.append("y");
         * 	//		sb.append("p");
         * 	//		sb.delete(0, sb.indexOf("9")+1);
         * 	//		System.out.println(sb.toString());
         * 	//
         * 	//		System.out.println("========================");
         */

//		测试用例
//		String  a = "abcabcbb"; // 期望结果 3
//		String  a = "pwwkew"; // 期望结果 3
        String a = "pwpwkew"; // 期望结果 4/
//        String a = "abba"; // 期望结果 2
//        System.out.println(a);
        System.out.println(" 无重复字符的最长子串(长度)是 " + lengthOfLongestSubstring6(a));

        /**
         * 测试dalao的方法和我的方法的运行时间的差别
         *	//		long start = System.currentTimeMillis();
         * //		for(int i=0;i<100000;i++) {
         * ////			System.out.print(lengthOfLongestSubstring2(a));
         * //			lengthOfLongestSubstring2(a);
         * //		}
         * //		System.out.println(" 自己的方法跑一万遍花的时间 "+(System.currentTimeMillis()-start));
         * //
         * //		long start2 = System.currentTimeMillis();
         * //		for(int i=0;i<100000;i++) {
         * ////			System.out.print(lengthOfLongestSubstring4(a));
         * //			lengthOfLongestSubstring4(a);
         * //		}
         * //		System.out.println(" 大佬的方法跑一万遍花的时间 "+(System.currentTimeMillis()-start2));
         *
         * //		 自己的方法跑一万遍花的时间 140
         * //		 大佬的方法跑一万遍花的时间 25
         *
         */


////        // 测试dalao的方法和我的方法的运行时间的差别
////        long start3 = System.currentTimeMillis();
////        for(int i=0;i<10000000;i++) {
////            //			System.out.print(lengthOfLongestSubstring2(a));
////            lengthOfLongestSubstring2(a);
////        }
////        System.out.println(" 自己的老方法跑一百万遍花的时间 "+(System.currentTimeMillis()-start3));
////
//         // 测试dalao的方法和我的方法的运行时间的差别
//        		long start = System.currentTimeMillis();
//        		for(int i=0;i<10000000;i++) {
//        //			System.out.print(lengthOfLongestSubstring2(a));
//        			lengthOfLongestSubstring5(a);
//        		}
//        		System.out.println(" 自己的方法跑一百万遍花的时间 "+(System.currentTimeMillis()-start));
////
//        		long start2 = System.currentTimeMillis();
//        		for(int i=0;i<10000000;i++) {
//        //			System.out.print(lengthOfLongestSubstring4(a));
//        			lengthOfLongestSubstring4(a);
//        		}
//        		System.out.println(" 大佬的方法跑一百万遍花的时间 "+(System.currentTimeMillis()-start2));
//        	//	 自己的方法跑一万遍花的时间 140
//        	// 	 大佬的方法跑一万遍花的时间 25
//
////        自己的方法跑一百万遍花的时间 890
////        大佬的方法跑一百万遍花的时间 549
//
////        自己的老方法跑一百万遍花的时间 4480
////        自己的方法跑一百万遍花的时间 623
////        大佬的方法跑一百万遍花的时间 509
//        改为用map以后
//            long start2 = System.currentTimeMillis();
//            for(int i=0;i<10000000;i++) {
//        //			System.out.print(lengthOfLongestSubstring4(a));
//        			lengthOfLongestSubstring4(a);
//        		}
//        		System.out.println(" 大佬的方法跑一百万遍花的时间 "+(System.currentTimeMillis()-start2));
//        long start6 = System.currentTimeMillis();
//        for(int i=0;i<10000000;i++) {
//            //			System.out.print(lengthOfLongestSubstring4(a));
//            lengthOfLongestSubstring6(a);
//        }
//        System.out.println(" 自己用map的方法跑一百万遍花的时间 "+(System.currentTimeMillis()-start6));
//        long start7 = System.currentTimeMillis();
//        for(int i=0;i<10000000;i++) {
//            //			System.out.print(lengthOfLongestSubstring4(a));
//            lengthOfLongestSubstring4(a);
//        }
//        System.out.println(" 自己的有if的方法跑一百万遍花的时间 "+(System.currentTimeMillis()-start7));


    }

    /**
     * //	自己写的3version3 , id:6 ，  改用map来存储上次出现的下标
     * 	//	不用stringbuilder试试,别人的方法是不用string数组，也不用stringBuilder，直接用string自己的charAt和两个下标数字
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring6(String s) {
        int len = s.length();
        if (len <= 1) {
            return len;
        }
//        int[] last = new int[128];
//        for (int i=0;i<last.length;i++){
//            last[i]=-1;
//        }
        Map<Integer,Integer> map = new HashMap<>();
        int res = 0;
        int start = 0, end = 0;
        for (int i = 0; i < len; i++) {
            int index = s.charAt(i);
//            前面两个条件的顺序换了执行时间好像差不多
//            if (last[index]>-1 && i != last[index]   && start <= last[index] + 1 ) {
//                start = last[index] + 1;
//            }
//            上面的if精简一下，就是选择 现在的start，和这个字母上次出现的下标相比， 大的那个
            start = Math.max(start, map.containsKey(index)?map.get(index) + 1:-1);
//            last[index] = i;
            map.put(index,i);
            res = Math.max(res, i - start + 1);
        }
        return res;
    }

    /**
     * //	自己写的3version2 , id:5  ,修改后删除多余代码及注释
     * 	//	不用stringbuilder试试,别人的方法是不用string数组，也不用stringBuilder，直接用string自己的charAt和两个下标数字
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring5(String s) {
        int len = s.length();
        if (len <= 1) {
            return len;
        }
        int[] last = new int[128];
        for (int i=0;i<last.length;i++){
            last[i]=-1;
        }
        int res = 0;
        int start = 0, end = 0;
        for (int i = 0; i < len; i++) {
            int index = s.charAt(i);
//            前面两个条件的顺序换了执行时间好像差不多
            if (last[index]>-1 && i != last[index]   && start <= last[index] + 1 ) {
                start = last[index] + 1;
            }
//            上面的if精简一下，就是选择 现在的start，和这个字母上次出现的下标相比， 大的那个
//            start = Math.max(start, last[index] + 1);
            last[index] = i;
            res = Math.max(res, i - start + 1);
        }
        return res;
    }

	/**
	 * //	大佬的高性能（运行时间很低）解法解析
	 * @param s  但是由于用的是asc2码，所以遇到中文或者其他符号这个数组就不够用了，而且很冗余，所以建议也能用map
	 * @return
	 */
    public static int lengthOfLongestSubstring4(String s) {
        // 记录字符上一次出现的位置,这个是asc2码表,纯字母的asc2码值都是在128以内的
        int[] last = new int[128];
		// 先把所有字符上一次出现的位置都初始化为0
        for (int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();
        int res = 0;
		// 窗口开始位置
        int start = 0;
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res = Math.max(res, i - start + 1);
            last[index] = i;
        }
        return res;
    }

	/**
	 * //	自己写的3
	 * 	//	不用stringbuilder试试,别人的方法是不用string数组，也不用stringBuilder，直接用string自己的charAt和两个下标数字
	 * @param s
	 * @return
	 */
    public static int lengthOfLongestSubstring3(String s) {
        int len = s.length();
        if (len <= 1) {
            return len;
        }
        int[] last = new int[128];
        int res = 0;
        int start = 0, end = 0;
        for (int i = 0; i < len; i++) {
			// 这个是字母在last数组内所在的下标
            int index = s.charAt(i);
			// 如果当前的下标，不等于这个字母上一次出现的值,那么就修改开始下标为这个已经出现过一次的字符的后一位
            if (i != last[index] &&  last[index]>0) {
                start = last[index] + 1;
            }
            System.out.println(" i: " + i + " char: " + s.charAt(i) + " start: "
                    + start + " last[index]: " + last[index]);
            last[index] = i;
			//	else {
			//		// 否则不做操作，
			//	}
			//	max = i-start+1;// 这个就是当前最长字串
            res = Math.max(res, i - start + 1);
        }
        return res;
    }

    //	�Լ�д��2 ȥ���������    �������ȷ������̫��ʱ̫ռ�ڴ档�ҵķ����ǻ����㷨���������Ǵ�����stringbuilder�����԰�stringbuilderȥ����
//	
    public static int lengthOfLongestSubstring2(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int res = 0;
        String[] a = s.split("");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            int index1 = sb.indexOf(a[i]);
            sb.append(a[i]);// �����˳�����Ȳ�����鲢ɾ��
            if (index1 != sb.lastIndexOf(a[i])) {
                sb.delete(0, index1 + 1);
            }
            res = Math.max(res, sb.length());
        }
        return res;
    }

    //	�Լ�д��1
    public static int lengthOfLongestSubstring(String s) {

        if (s.length() <= 1) {
            return s.length();
        }
        int res = 0;
//		String resStr = "";

        String[] a = s.split("");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            int index1 = sb.indexOf(a[i]);

//			 ������1begin
            int index2 = sb.lastIndexOf(a[i]);
            System.out.println(" 此字符串是 " + a[i] + " 第一次出现的下标是 " + index1 + " 最后一次出现的下标是 " + index2);
//			������1end
            sb.append(a[i]);
            if (index1 != sb.lastIndexOf(a[i])) {
                sb.delete(0, index1 + 1);
            }
//			else {
//				sb.append(a[i]);
//			}
//			resStr = sb.toString();
            System.out.println(sb.toString()); // �����ã�Ҫɾ
            res = Math.max(res, sb.length());
        }
        return res;

    }
}
