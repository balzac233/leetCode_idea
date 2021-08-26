package tiku.测试一些东西.正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description
 * @author: lvhengce
 * @create: 2021-08-26
 **/
public class testPattern {

    public static void main(String[] args) {
        String content = "I am [noob from 4866666runoob.co]m";
//        写正则表达式的时候尽量写好粘到java编译器里面，她会自动帮你加上反斜杠
//        .*?(\d+)runoob.*
//             .*?(\d){3,6}runoob.*
        //             .*(\s+)(\d){3,6}runoob.*
//        String pattern = ".*(\\d+)runoob.*";
//        String pattern = ".*?(\\d+)runoob.*";
//        String pattern = ".*?(\\d){3,6}runoob.*";
        String pattern = ".*(\\s+)(\\d){3,6}runoob.*";
        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println("字符串中是否包含了‘runoob’子字符串？" + isMatch);

//        (.*?\[(.*?b\sf).*?(\d{3}(\d+runoob.*?))\].*)
//        b\sf
//        String p = ".*?(\\[(b\\sf)(\\d{3}(\\d+runoob))\\]).*";
//        String p = "(\\d{3}(\\d+runoob))";
//        (\d{3}(\d+runoob.*?))\])
//        String p = ".*?(\\[(b\\sf)(\\d{3}(\\d+runoob.*?))\\]).*";
//        String p = "(\\d{3}(\\d+runoob.*?))\\]";
        String p = "(.*?\\[(.*?b\\sf).*?(\\d{3}(\\d+runoob.*?))\\].*)";
        Pattern r = Pattern.compile(p);
        Matcher m = r.matcher(content);
        if (m.find()) {
//            这个下标的顺序是从左括号开始计算的
            System.out.println("Found value: " + m.group(0));
            System.out.println("Found value: " + m.group(1));
            System.out.println("Found value: " + m.group(2));
            System.out.println("Found value: " + m.group(3) );
            System.out.println("Found value: " + m.group(4) );
        } else {
            System.out.println("no match");
        }

    }


}
