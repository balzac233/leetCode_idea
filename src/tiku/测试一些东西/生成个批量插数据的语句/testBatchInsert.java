package tiku.测试一些东西.生成个批量插数据的语句;

/**
 * @description
 * @author: lvhengce
 * @create: 2021-08-25
 **/
public class testBatchInsert {

    public static void main(String[] args) {

        String head = "insert into test_index(name,email) values ";
        StringBuilder sb = new StringBuilder(head);

//        StringBuilder

//        sb.append("abcde");
//        sb.delete(sb.length()-1,sb.length());
//        System.out.println(sb.toString());

//        char[] a = new char[10];

//        for (int j=0;j<a.length;j++){
//            a[j] = (char)(96+Math.random()*26+1);
//        }

//        System.out.println(a.toString());
//        String b = new String(a);
//        System.out.println(b);

        for (int i=0;i<100000;i++){
            char[] a = new char[(int)(Math.random()*10+3)];
            for (int j = 0; j < a.length; j++) {
                a[j] = (char) (96 + Math.random() * 26 + 1);
            }
            String b = new String(a);
            sb.append("('").append(a).append("','").append(b+"@pp.com").append("'),");
        }
        sb.delete(sb.length()-1,sb.length());
        System.out.println(sb.toString());

    }

}
