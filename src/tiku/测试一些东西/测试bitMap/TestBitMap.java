package tiku.测试一些东西.测试bitMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description
 * @author: lvhengce
 * @create: 2021-08-24
 **/
public class TestBitMap {

    private static String[] fruit = new String[]{"苹果", "香蕉", "西瓜", "梨", "草莓", "葡萄", "杨梅", "榴莲"};
//                                                  1       2     4     8      16    32     64     128

    public static void main(String[] args) {

//        int[] fruit = new int[];
//        Map<Byte,String> map = new HashMap<>();

        int len = fruit.length;
        int pow2 = 1;

//        Map<String,Integer> map = new HashMap<>();

////        简历map索引
//        for (int i=0;i<len;i++){
//            map.put(fruit[len-i-1],pow2 << i);
////            pow2 = pow2*2;
//        }


//      01001000
//        8 + 64 = 72   期望值 草莓香蕉

        int fruitNum = 72;
        List<String> fruitList = fruitList(fruitNum);
        fruitList.forEach(System.out::println);

    }

    public static List<String> fruitList(int n) {
        int len = fruit.length;
        int init = 1;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if ((n & (init << i)) > 0) {
//                System.out.println(" 水果有 " + fruit[i]);
                res.add(fruit[i]);
            }
        }
        return res;
    }

}
