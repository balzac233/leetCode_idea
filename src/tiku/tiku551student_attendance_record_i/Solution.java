package tiku.tiku551student_attendance_record_i;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.alibaba.fastjson.*;


public class Solution {

	public static void main(String[] args) {
	
//		String s = "PPALLP";// true
//		String s ="PPALLL";// false
		String s ="LL";
		System.out.println(" �Ƿ�ȫ�ڣ� "+checkRecord(s));
	}
	
	public boolean checkRecord3(String s) {
		
//		JSONObject jsonObject = new JSONObject();
		
		return false;
		
	}
	
//	���������е�һ�仰�汾
	public boolean checkRecord2(String s) {
	    return s.indexOf("A") == s.lastIndexOf("A") && !s.contains("LLL");
	}
	
	public static boolean checkRecord(String s) {
		
		String[] ss = s.split("");
		Map<String, Integer> map = new HashMap<>();
		int later = 0;
		int laterFlag = 0;
		for(int i=0;i<ss.length;i++) {
			if(ss[i].equals("L")) {
				later++;
				if (later>=3) {
					laterFlag = 1;
				}
			}else {
				later=0;
			}
			map.put(ss[i], map.containsKey(ss[i])?map.get(ss[i])+1:1 );
		}
		for(String g:map.keySet()) {
			System.out.println(" key =  "+g+" val =  "+map.get(g));
		}
		if (laterFlag==0 && ( map.containsKey("A") && map.get("A")<=1)) {
			return true;
		}
		return false;

    }
	
}
