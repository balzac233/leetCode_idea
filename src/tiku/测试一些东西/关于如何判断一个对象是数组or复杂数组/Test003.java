package tiku.测试一些东西.关于如何判断一个对象是数组or复杂数组;

import java.lang.reflect.Array;

/**
 * @description
 * @author: lvhengce
 * @create: 2021-08-26
 **/
public class Test003 {

    public static void main(String[] args) {

        //        混合数组
        Object[]cc = {new Object(),1};
        Number[] dd = {new Long(1),1.2};

        int[] a = new int[]{1,2,3};

//        System.out.println(a.getClass().isArray());
//        System.out.println(a instanceof int[]);

        test004(a);

    }

    public static void test004(Object ob){

        System.out.println(ob.getClass().isArray());
        System.out.println(ob instanceof int[]);

        int[] a =(int[]) ob;

        for (int i=0;i<a.length;i++){
            System.out.print(" , "+a[i]);
        }
        System.out.println();
        System.out.println(Array.getLength(ob));

    }

}
