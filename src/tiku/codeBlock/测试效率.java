package tiku.codeBlock;

import java.util.HashMap;
import java.util.Map;

public class 测试效率 {

    public static void main(String[] args) {

        // test efficiency
        long start = System.currentTimeMillis();
        for (int i=0;i<10000000;i++){
            test01();
        }
        System.out.println(" 测试上面那个函数一千万遍用的毫秒数 "+(System.currentTimeMillis()-start));

    }

    public static int test01(){

        int i=0;
        Map<Integer,Integer> map = new HashMap<>();
        while(i<10){
            i++;
            map.put(i,i*10);
        }
        return i;

    }

}
