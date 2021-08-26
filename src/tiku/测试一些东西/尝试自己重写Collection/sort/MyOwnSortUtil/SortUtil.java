package tiku.测试一些东西.尝试自己重写Collection.sort.MyOwnSortUtil;

import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @description
 * @author: lvhengce
 * @create: 2021-08-24
 **/
public class SortUtil {

    public static void main(String[] args) {

        List<User003> userList = new ArrayList<>();
        userList.add(new User003.Builder().s(106).age(12).id(4566L).build());

        userList.add(new User003.Builder().s(101).age(14).id(4566L).build());
        userList.add(new User003.Builder().s(102).age(12).id(4566L).build());
        userList.add(new User003.Builder().s(106).age(12).id(4567L).build());
        userList.add(new User003.Builder().s(106).age(13).id(4567L).build());
        userList.add(new User003.Builder().s(201).age(12).id(4566L).build());
        userList.add(new User003.Builder().s(205).age(15).id(4566L).build());

        userList.forEach(System.out::println);
        System.out.println("===========");
        sortMtOrderByLocalDateTime(userList);
        userList.forEach(System.out::println);

    }

//    return  1 就是 o1比较大，return -1就是o2比较大，return 0 就是相等

    public static void sortMtOrderByLocalDateTime(List<User003> list) {
        if (list != null && list.size() > 0) {
//            重写sort，把实体类中的StartTime属性拿出来对比。
            Collections.sort(list, new Comparator<User003>() {
                @Override
                public int compare(User003 o1, User003 o2) {
                    int diff1 = o1.s - o2.s;
                    int diff2 = o1.age - o2.age;
                    Long diff = o1.id - o2.id;
                    if (diff1 < 0) {
                        return 1;
                    } else if (diff1 > 0) {
                        return -1;
                    } else if (diff2 < 0) {
                        return 1;
                    } else if (diff2 > 0) {
                        return -1;
                    } else if (diff < 0L) {
                        return 1;
                    } else {
                        return diff > 0L ? -1 : 0;
                    }
                }
            });
        }
    }

}
