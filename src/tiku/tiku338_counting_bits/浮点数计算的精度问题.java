package tiku.tiku338_counting_bits;

public class 浮点数计算的精度问题 {

    public static void main(String[] args) {

//        double x1 = Math.sqrt(Math.pow(2,30)-1);
//        double x2 = Math.sqrt(Math.pow(2,30));
//
////        double x1 = Math.sqrt(Math.pow(2,10)-1);
////        double x2 = Math.sqrt(Math.pow(2,10));
//
//        System.out.println(x1);
//        System.out.println(x2);
//        System.out.println(x1-x2);
//        System.out.println((x1-x2)%1);
//
//        System.out.println(x1==32767);
//        System.out.println(x2==32767);

        int a1 = 32;
        int a2 = 33;

        System.out.println((a1 & a1-1));
        System.out.println((a2 & a2-1));

    }

}
