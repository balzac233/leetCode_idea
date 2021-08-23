package tiku.工作.楼宇卫视.关于引用的问题;

import java.util.*;

/**
 * @description
 * @author: lvhengce
 * @create: 2021-08-23
 **/
public class testPage {

    public static void main(String[] args) {

        Page page = new Page();

        List<Map<String,Object>> a = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("age",14);
        map.put("name","fee");
        Map<String,Object> map2 = new HashMap<>();
        map2.put("age",64);
        map2.put("name","qqq");
        a.add(map);
        a.add(map2);
        page.setResult(a);

        List<Map<String,Object>> b = page.getResult();

        Map<String,Object> map3 = new HashMap<>();
        map3.put("age",117);
        map3.put("name","ppo");

        b.add(map3);

        for (Map<String,Object> m:b){
            m.put("age",(int)m.get("age")+1);
        }

        List<Map<String,Object>> c = page.getResult();
        for (Map<String,Object> m2:c){
            Set<Map.Entry<String, Object>> entries = m2.entrySet();
            for (Map.Entry mm:entries){
                System.out.println(" mmkey "+mm.getKey()+" mmvalue "+mm.getValue());
            }

        }


    }

}
