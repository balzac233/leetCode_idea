package tiku.工作.楼宇卫视.输出菜单;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description 收费项目分类-实体类
 * @author: lvhengce
 * @create: 2021-08-31
 **/


public class ChargeItemCategoryEntity {

    /**
     * @Description 表id
     * @param: 
     * @return:
     * @auther: lvhengce
     * @date: 2021/8/31 12:10
     */
    

    String objectId;


    String createBy;

    /**
     * Constructor for instances of type {@link ChargeItemCategoryEntity} using the Builder implementation
     */
    private ChargeItemCategoryEntity(Builder builder) {
        this.objectId = builder.objectId;
        this.createBy = builder.createBy;
        this.createTime = builder.createTime;
        this.modifiedBy = builder.modifiedBy;
        this.modifiedTime = builder.modifiedTime;
        this.version = builder.version;
        this.isDeleted = builder.isDeleted;
        this.projectId = builder.projectId;
        this.parentId = builder.parentId;
        this.categoryLevel = builder.categoryLevel;
        this.categoryName = builder.categoryName;
        this.childList = builder.childList;
    }

    public ChargeItemCategoryEntity(){

    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public LocalDateTime getModifiedTime() {
        return modifiedTime;
    }

    /**
     * @description 形成树list，找爸爸。
     * 遍历map里面的对象的父id，如果父菜单已经有孩子列表了，那么就往里面塞，
     * 没有的话就创建一个孩子列表把自己塞里面
     * @author luomeng
     * @updateTime 2021/8/31 17:00
     * @throws
     */
    public static List<ChargeItemCategoryEntity> buildTree(List<ChargeItemCategoryEntity> list) {
        //用来返回的list
        List<ChargeItemCategoryEntity> newList = new ArrayList<>();
        //用空间换时间的方法降低时间复杂度 把所有的对象都放入map
        Map<String, ChargeItemCategoryEntity> map = new HashMap<>();
        for (ChargeItemCategoryEntity cic : list) {
            map.put(cic.getObjectId(), cic);
            //将最高层级的类放入新的list
            if (cic.getCategoryLevel() == 1) {
                newList.add(cic);
            }
        }
        //将父子对象一一匹对
        for (String key : map.keySet()) {
            String parentId = map.get(key).getParentId();
            if (map.get(parentId) != null) {
//                如果父菜单已经有孩子列表了，那么就往里面塞，
                if (map.get(parentId).getChildList() != null) {
                    map.get(parentId).getChildList().add(map.get(key));
//                    没有的话就创建一个孩子列表把自己塞里面
                } else {
                    List<ChargeItemCategoryEntity> childList = new ArrayList<>();
                    childList.add(map.get(key));
                    map.get(parentId).setChildList(childList);
                }
            }
        }
        return newList;
    }

    /**
     * @description 形成树list，找爸爸。
     * 遍历map里面的对象的父id，如果父菜单已经有孩子列表了，那么就往里面塞，
     * 没有的话就创建一个孩子列表把自己塞里面
     * @author luomeng
     * @updateTime 2021/8/31 17:00
     * @throws
     */
    public static ChargeItemCategoryEntity buildTree2(List<ChargeItemCategoryEntity> list) {
//        //用来返回的list
//        List<ChargeItemCategoryEntity> newList = new ArrayList<>();
        ChargeItemCategoryEntity newList = new ChargeItemCategoryEntity();
        //用空间换时间的方法降低时间复杂度 把所有的对象都放入map
        Map<String, ChargeItemCategoryEntity> map = new HashMap<>();
        for (ChargeItemCategoryEntity cic : list) {
            map.put(cic.getObjectId(), cic);
            //将最高层级的类放入新的list
            if (cic.getCategoryLevel() == 1) {
//                newList.add(cic);
                newList = cic;
            }
        }
        //将父子对象一一匹对
        for (String key : map.keySet()) {
            String parentId = map.get(key).getParentId();
            if (map.get(parentId) != null) {
//                如果父菜单已经有孩子列表了，那么就往里面塞，
                if (map.get(parentId).getChildList() != null) {
                    map.get(parentId).getChildList().add(map.get(key));
//                    没有的话就创建一个孩子列表把自己塞里面
                } else {
                    List<ChargeItemCategoryEntity> childList = new ArrayList<>();
                    childList.add(map.get(key));
                    map.get(parentId).setChildList(childList);
                }
            }
        }
        return newList;
    }


    public void setModifiedTime(LocalDateTime modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getCategoryLevel() {
        return categoryLevel;
    }

    public void setCategoryLevel(Integer categoryLevel) {
        this.categoryLevel = categoryLevel;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<ChargeItemCategoryEntity> getChildList() {
        return childList;
    }

    public void setChildList(List<ChargeItemCategoryEntity> childList) {
        this.childList = childList;
    }

    LocalDateTime createTime;

    String modifiedBy;

    LocalDateTime modifiedTime;


    Integer version;


    Boolean isDeleted;

    String projectId;
    /**
     * @Description 父id
     * @param:
     * @return:
     * @auther: lvhengce
     * @date: 2021/8/31 12:12
     */
    String parentId;

    /**
     * @Description 菜单层级
     * @param:
     * @return:
     * @auther: lvhengce
     * @date: 2021/8/31 12:11
     */
    Integer categoryLevel;

    /**
     * @Description 菜单名称
     * @param:
     * @return:
     * @auther: lvhengce
     * @date: 2021/8/31 12:11
     */
    String categoryName;

    /**
     * @Description 子菜单列表
     * @param: 
     * @return:
     * @auther: lvhengce
     * @date: 2021/8/31 14:16
     */
    List<ChargeItemCategoryEntity> childList;

    /**
     * Builder for instances of type {@link ChargeItemCategoryEntity}
     */
    public static final class Builder {
        private String objectId;
        private String createBy;
        private LocalDateTime createTime;
        private String modifiedBy;
        private LocalDateTime modifiedTime;
        private Integer version;
        private Boolean isDeleted;
        private String projectId;
        private String parentId;
        private Integer categoryLevel;
        private String categoryName;
        private List<ChargeItemCategoryEntity> childList;

        /**
         * Set the value of the field objectId of the target instance of type {@link ChargeItemCategoryEntity}
         */
        public Builder objectId(final String objectId) {
            this.objectId = objectId;
            return this;
        }

        /**
         * Set the value of the field createBy of the target instance of type {@link ChargeItemCategoryEntity}
         */
        public Builder createBy(final String createBy) {
            this.createBy = createBy;
            return this;
        }

        /**
         * Set the value of the field createTime of the target instance of type {@link ChargeItemCategoryEntity}
         */
        public Builder createTime(final LocalDateTime createTime) {
            this.createTime = createTime;
            return this;
        }

        /**
         * Set the value of the field modifiedBy of the target instance of type {@link ChargeItemCategoryEntity}
         */
        public Builder modifiedBy(final String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        /**
         * Set the value of the field modifiedTime of the target instance of type {@link ChargeItemCategoryEntity}
         */
        public Builder modifiedTime(final LocalDateTime modifiedTime) {
            this.modifiedTime = modifiedTime;
            return this;
        }

        /**
         * Set the value of the field version of the target instance of type {@link ChargeItemCategoryEntity}
         */
        public Builder version(final Integer version) {
            this.version = version;
            return this;
        }

        /**
         * Set the value of the field isDeleted of the target instance of type {@link ChargeItemCategoryEntity}
         */
        public Builder isDeleted(final Boolean isDeleted) {
            this.isDeleted = isDeleted;
            return this;
        }

        /**
         * Set the value of the field projectId of the target instance of type {@link ChargeItemCategoryEntity}
         */
        public Builder projectId(final String projectId) {
            this.projectId = projectId;
            return this;
        }

        /**
         * Set the value of the field parentId of the target instance of type {@link ChargeItemCategoryEntity}
         */
        public Builder parentId(final String parentId) {
            this.parentId = parentId;
            return this;
        }

        /**
         * Set the value of the field categoryLevel of the target instance of type {@link ChargeItemCategoryEntity}
         */
        public Builder categoryLevel(final Integer categoryLevel) {
            this.categoryLevel = categoryLevel;
            return this;
        }

        /**
         * Set the value of the field categoryName of the target instance of type {@link ChargeItemCategoryEntity}
         */
        public Builder categoryName(final String categoryName) {
            this.categoryName = categoryName;
            return this;
        }

        /**
         * Set the value of the field childList of the target instance of type {@link ChargeItemCategoryEntity}
         */
        public Builder childList(final List<ChargeItemCategoryEntity> childList) {
            this.childList = childList;
            return this;
        }

        /**
         * Create a new instance of type {@link ChargeItemCategoryEntity}
         */
        public ChargeItemCategoryEntity build() {
            return new ChargeItemCategoryEntity(this);
        }
    }
}
