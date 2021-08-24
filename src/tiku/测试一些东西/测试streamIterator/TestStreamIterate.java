package tiku.测试一些东西.测试streamIterator;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description
 * @author: lvhengce
 * @create: 2021-08-24
 **/
public class Test002 {

    public static void main(String[] args) {

        int stert = 10;
        int end = 20;

//        .limit 里面意思是次数， Stream.iterate ，第一个参数意思就是初始化，第二个意思就是自己定义个变量，
//        变量类型就是List里面的类型。
        List<Integer> localDateList = (List) Stream.iterate(stert, (date) -> {
            return date+1;
        }).limit(end-stert).collect(Collectors.toList());

        localDateList.forEach(System.out::println);

    }

}
