package tiku.测试一些东西.测试optional;

import java.util.Optional;

/**
 * @description
 * @author: lvhengce
 * @create: 2021-08-23
 **/
public class 测试optional {

    public static void main(String[] args) {
        System.out.println("1. 三目运算===========================");
        boolean one = (Boolean.TRUE) ? a():b();
        System.out.println(one);
        //输出：
        //--a--
        //true
        //说明：根据条件的真假，只会执行a或b方法的某一个。
        System.out.println("2. orElse()===========================");
        System.out.println(Optional.ofNullable(Boolean.FALSE).orElse(b()));
        //--b--
        //false
        //说明：b()方法被执行了，将b方法的返回值true作为参数传给了orElse(true)方法，但实际并未使用true。
        // 其实按正常来说，就不应该执行b(), 那下面的orElseGet() 方法就是解决这个问题的。
        System.out.println("3. orElseGet()===========================");
        System.out.println(Optional.ofNullable(Boolean.FALSE).orElseGet(() -> b()));
        //false
        //说明：不为null时，直接打印了 Boolean.FALSE的值，根本没有去调用b()方法
        System.out.println("4. of()===========================");
        System.out.println(Optional.of(null).orElseGet(() -> b()));
        //抛出异常
    }

    public static boolean a() {
        System.out.println("--a--");
        return true;
    }
    public static boolean b() {
        System.out.println("--b--");
        return true;
    }

}
