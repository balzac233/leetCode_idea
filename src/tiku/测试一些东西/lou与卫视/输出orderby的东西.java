package tiku.测试一些东西.lou与卫视;

/**
 * @description
 * @author: lvhengce
 * @create: 2021-08-30
 **/
public class 输出orderby的东西 {

    public static void main(String[] args) {

        String s = "SUBSTRING_INDEX( tarname.building_name, ',', 1 ),if(LENGTH(SUBSTRING_INDEX( tarname.building_area_name, ',', 1 ))-LENGTH" +
                "(REPLACE(SUBSTRING_INDEX( tarname.building_area_name, ',', 1 ),';',''))<2,0,GetNum ( SUBSTRING_INDEX(SUBSTRING_INDEX(tarname" +
                ".building_area_name,';',2),';',1) )),if(LENGTH(SUBSTRING_INDEX( tarname.building_area_name, ',', 1 ))-LENGTH(REPLACE(SUBSTRING_INDEX( " +
                "tarname.building_area_name, ',', 1 ),';',''))<2,CONVERT (IF(LEFT ( SUBSTRING_INDEX( SUBSTRING_INDEX( tarname.building_area_name, ',', 1 " +
                "), ';', 1 ), 1 ) = 'B',- GetNum ( SUBSTRING_INDEX( SUBSTRING_INDEX( tarname.building_area_name, ',', 1 ), ';', 1 ) ),GetNum ( " +
                "SUBSTRING_INDEX( SUBSTRING_INDEX( tarname.building_area_name, ',', 1 ), ';', 1 ) ) ),DECIMAL ( 10, 0 ) ),CONVERT (IF(LEFT ( " +
                "SUBSTRING_INDEX(SUBSTRING_INDEX( SUBSTRING_INDEX( tarname.building_area_name, ',', 1 ), ';', 2 ), ';', -1), 1 ) = 'B',- GetNum " +
                "(SUBSTRING_INDEX(SUBSTRING_INDEX( SUBSTRING_INDEX( tarname.building_area_name, ',', 1 ), ';', 2 ), ';', -1) ),GetNum ( SUBSTRING_INDEX" +
                "(SUBSTRING_INDEX( SUBSTRING_INDEX( tarname.building_area_name, ',', 1 ), ';', 2 ), ';', -1) ) ),DECIMAL ( 10, 0 ) )),GetNum ( " +
                "SUBSTRING_INDEX( SUBSTRING_INDEX( tarname.building_area_name, ',', 1 ), ';',- 1 ) )";

        System.out.println(s);

//        SUBSTRING_INDEX( tarname.building_name, ',', 1 ),if(LENGTH(SUBSTRING_INDEX( tarname.building_area_name, ',', 1 ))-LENGTH(REPLACE(SUBSTRING_INDEX( tarname.building_area_name, ',', 1 ),';',''))<2,0,GetNum ( SUBSTRING_INDEX(SUBSTRING_INDEX(tarname.building_area_name,';',2),';',1) )),if(LENGTH(SUBSTRING_INDEX( tarname.building_area_name, ',', 1 ))-LENGTH(REPLACE(SUBSTRING_INDEX( tarname.building_area_name, ',', 1 ),';',''))<2,CONVERT (IF(LEFT ( SUBSTRING_INDEX( SUBSTRING_INDEX( tarname.building_area_name, ',', 1 ), ';', 1 ), 1 ) = 'B',- GetNum ( SUBSTRING_INDEX( SUBSTRING_INDEX( tarname.building_area_name, ',', 1 ), ';', 1 ) ),GetNum ( SUBSTRING_INDEX( SUBSTRING_INDEX( tarname.building_area_name, ',', 1 ), ';', 1 ) ) ),DECIMAL ( 10, 0 ) ),CONVERT (IF(LEFT ( SUBSTRING_INDEX(SUBSTRING_INDEX( SUBSTRING_INDEX( tarname.building_area_name, ',', 1 ), ';', 2 ), ';', -1), 1 ) = 'B',- GetNum (SUBSTRING_INDEX(SUBSTRING_INDEX( SUBSTRING_INDEX( tarname.building_area_name, ',', 1 ), ';', 2 ), ';', -1) ),GetNum ( SUBSTRING_INDEX(SUBSTRING_INDEX( SUBSTRING_INDEX( tarname.building_area_name, ',', 1 ), ';', 2 ), ';', -1) ) ),DECIMAL ( 10, 0 ) )),GetNum ( SUBSTRING_INDEX( SUBSTRING_INDEX( tarname.building_area_name, ',', 1 ), ';',- 1 ) )


    }

}
