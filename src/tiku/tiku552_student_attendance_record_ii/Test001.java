package tiku.tiku552_student_attendance_record_ii;

public class Test001 {

    public static void main(String[] args) {
        //          j*3 + k  ，例如 4 ，就是缺勤1天，迟到1天 k*2 + j 这种不行，数字为2就不知道到底是缺勤一天

        for (int j=0;j<=1;j++){
            for (int k=0;k<=2;k++){
                System.out.println(j*3+k);
            }
        }

        System.out.println("=======================");

        for (int j=0;j<=1;j++){
            for (int k=0;k<=2;k++){
                System.out.println(k*2+j);
            }
        }

    }

}
