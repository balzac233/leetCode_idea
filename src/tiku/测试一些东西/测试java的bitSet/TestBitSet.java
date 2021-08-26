package tiku.测试一些东西.测试java的bitSet;

import java.util.BitSet;

/**
 * @description
 * @author: lvhengce
 * @create: 2021-08-24
 **/
public class TestBitSet {

//    java.util.BitSet的底层是long数组，.size()方法返回的是BitSet当前位数，因为long是64位的，所以size返回的值也是64的整数倍，
//    所以在上面的代码中发现，我在构造函数中传入初始化长度1~64中的任意一个值，size的大小都是64位，因为此时long数组的长度只有1，
//    而我一旦将其设置成65，size的大小就变成128了。

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 22, 0, 3, 63};
        BitSet bitSet = new BitSet(1);
        System.out.println(bitSet.size());   //64
        bitSet = new BitSet(65);
        System.out.println(bitSet.size());   //128
        bitSet = new BitSet(23);
        System.out.println(bitSet.size());   //64
        bitSet = new BitSet(8);
        System.out.println(bitSet.size());   //64

        //将数组内容组bitmap
        for (int i = 0; i < array.length; i++) {
            bitSet.set(array[i], true);
        }

        System.out.println(bitSet.get(22));
        System.out.println(bitSet.get(60));

        System.out.println("下面开始遍历BitSet：");
        for (int i = 0; i < bitSet.size(); i++) {
            System.out.println(bitSet.get(i));
        }


    }
}
