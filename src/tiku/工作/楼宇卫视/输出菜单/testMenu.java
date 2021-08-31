package tiku.工作.楼宇卫视.输出菜单;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * @description
 * @author: lvhengce
 * @create: 2021-08-31
 **/
public class testMenu {

    public static void main(String[] args) {

//        ChargeItemCategoryEntity(objectId=4f447eeb-0a06-11ec-8005-80fa5b3798e6, version=0, isDeleted=false, projectId=21ef6cbe-1f44-484f-bd83-9e225ddf376b, parentId=, categoryLevel=1, categoryName=全部, childList=null)
//        ChargeItemCategoryEntity(objectId=9b7e5d6a-0a06-11ec-8005-80fa5b3798e6, version=0, isDeleted=false, projectId=21ef6cbe-1f44-484f-bd83-9e225ddf376b, parentId=4f447eeb-0a06-11ec-8005-80fa5b3798e6, categoryLevel=2, categoryName=前期欠费, childList=null)
//        ChargeItemCategoryEntity(objectId=9b7e7a12-0a06-11ec-8005-80fa5b3798e6,  version=0, isDeleted=false, projectId=21ef6cbe-1f44-484f-bd83-9e225ddf376b, parentId=4f447eeb-0a06-11ec-8005-80fa5b3798e6, categoryLevel=2, categoryName=临时欠费, childList=null)
//        ChargeItemCategoryEntity(objectId=d8525dfe-0a06-11ec-8005-80fa5b3798e6, version=1, isDeleted=false, projectId=21ef6cbe-1f44-484f-bd83-9e225ddf376b, parentId=9b7e7a12-0a06-11ec-8005-80fa5b3798e6, categoryLevel=3, categoryName=车位费002, childList=null)
//        ChargeItemCategoryEntity(objectId=d852b644-0a06-11ec-8005-80fa5b3798e6,  version=0, isDeleted=false, projectId=21ef6cbe-1f44-484f-bd83-9e225ddf376b, parentId=9b7e7a12-0a06-11ec-8005-80fa5b3798e6, categoryLevel=3, categoryName=保管费, childList=null)


        List<ChargeItemCategoryEntity> chargeItemCategoryEntities = new ArrayList<>();
        chargeItemCategoryEntities.add(new ChargeItemCategoryEntity
                .Builder().objectId("4f447eeb-0a06-11ec-8005-80fa5b3798e6").parentId("").categoryName("全部").categoryLevel(1).build());
        chargeItemCategoryEntities.add(new ChargeItemCategoryEntity
                .Builder().objectId("9b7e5d6a-0a06-11ec-8005-80fa5b3798e6").parentId("4f447eeb-0a06-11ec-8005-80fa5b3798e6").categoryName("前期欠费").categoryLevel(2).build());
        chargeItemCategoryEntities.add(new ChargeItemCategoryEntity
                .Builder().objectId("444").parentId("9b7e5d6a-0a06-11ec-8005-80fa5b3798e6").categoryName("前期欠费-11").categoryLevel(3).build());
        chargeItemCategoryEntities.add(new ChargeItemCategoryEntity
                .Builder().objectId("555").parentId("444").categoryName("前期欠费-11-33").categoryLevel(4).build());
        chargeItemCategoryEntities.add(new ChargeItemCategoryEntity
                .Builder().objectId("9b7e7a12-0a06-11ec-8005-80fa5b3798e6").parentId("4f447eeb-0a06-11ec-8005-80fa5b3798e6").categoryName("临时欠费").categoryLevel(2).build());
        chargeItemCategoryEntities.add(new ChargeItemCategoryEntity
                .Builder().objectId("d8525dfe-0a06-11ec-8005-80fa5b3798e6").parentId("9b7e7a12-0a06-11ec-8005-80fa5b3798e6").categoryName("车位费002").categoryLevel(3).build());
        chargeItemCategoryEntities.add(new ChargeItemCategoryEntity
                .Builder().objectId("d852b644-0a06-11ec-8005-80fa5b3798e6").parentId("9b7e7a12-0a06-11ec-8005-80fa5b3798e6").categoryName("保管费").categoryLevel(3).build());
         ChargeItemCategoryEntity res = new ChargeItemCategoryEntity();
        if (chargeItemCategoryEntities.size() == 0) {
            System.out.println("查询出错--列表为空");
            return;
        }
        for (int i = 0; i < chargeItemCategoryEntities.size(); i++) {
            ChargeItemCategoryEntity ch = chargeItemCategoryEntities.get(i);
            if (ch.getCategoryLevel() == 1) {
                res = ch;
//                chargeItemCategoryEntities.remove(i);
                break;
            }
        }
        if (res == null) {
            System.out.println("查询出错--没有根菜单");
            return;
        }
        ChargeItemCategoryEntity res2 = getChildList(res, chargeItemCategoryEntities);

        List<ChargeItemCategoryEntity> list = res2.getChildList();
        if (list.size()<=0){
            System.out.println("除了根菜单没其他的了");
        }
        printList(res2);

    }

    public static ChargeItemCategoryEntity getChildList
            (ChargeItemCategoryEntity res, List<ChargeItemCategoryEntity> cList) {
        Queue<ChargeItemCategoryEntity> queue = new LinkedList<>();
        List<ChargeItemCategoryEntity> childList = new ArrayList<>();
        for (int i = 0; i < cList.size(); i++) {
            ChargeItemCategoryEntity ch = cList.get(i);
            if (ch.getParentId().equals(res.getObjectId())) {
                childList.add(ch);
                queue.offer(ch);
            }
        }
        res.setChildList(childList);
        while (queue.size() > 0) {
            int size = queue.size();
            for (int j=0;j<size;j++){
                ChargeItemCategoryEntity chParent = queue.poll();
                String objectId = chParent.getObjectId();
                List<ChargeItemCategoryEntity> childList2 = new ArrayList<>();
                for (int i=0;i<cList.size();i++){
                    ChargeItemCategoryEntity chChild = cList.get(i);
                    if (chChild.getParentId().equals(objectId)){
                        childList2.add(chChild);
                        queue.offer(chChild);
                    }
                }
//                childList = cList.stream().filter(chChild->chChild.getParentId().equals(objectId)).collect(Collectors.toList());
                chParent.setChildList(childList2);
            }
        }
        return res;
    }

    public static void printList(ChargeItemCategoryEntity res){
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<res.getCategoryLevel();i++){
            sb.append("\t");
        }
        System.out.println(sb.toString()+res.getCategoryName());
        if (null == res.getChildList() || res.getChildList().size()<=0){
            return;
        }
        List<ChargeItemCategoryEntity> chList = res.getChildList();
        for (ChargeItemCategoryEntity ch:chList){
            printList(ch);
        }

    }


}
