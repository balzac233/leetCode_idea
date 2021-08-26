package tiku.测试一些东西.二分法查找代码;

/**
 * @description
 * @author: lvhengce
 * @create: 2021-08-26
 **/
public class Testb {

    public static void main(String[] args) {

        int[] a = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int value =6;
        int index = binarySearch(a, value);
        System.out.println(index);


    }

    public static int binarySearch(int[] array,int value){
        int low = 0;
        int high = array.length-1;
        int middle;

        while(low <= high){
            middle = (low + high) / 2;

            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i]);

                if (i == middle) {
                    System.out.print("#");
                }
                System.out.print(" ");
            }
            System.out.println();


            if (array[middle] == value) {
                return middle;
            }

            if (value < array[middle]) {
                high = middle - 1;
            }

            if (value > array[middle]) {
                low = middle + 1;
            }
        }
        return -1;
    }

}
