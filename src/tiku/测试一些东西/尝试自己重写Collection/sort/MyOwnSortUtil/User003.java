package tiku.测试一些东西.尝试自己重写Collection.sort.MyOwnSortUtil;

/**
 * @description
 * @author: lvhengce
 * @create: 2021-08-24
 **/
public class User003 {

    Long id;
    Integer age;
    Integer s;

    /**
     * Constructor for instances of type {@link User003} using the Builder implementation
     */
    private User003(Builder builder) {
        this.id = builder.id;
        this.age = builder.age;
        this.s = builder.s;
    }

    public User003(Long id, Integer age, Integer s) {
        this.id = id;
        this.age = age;
        this.s = s;
    }

    @Override
    public String toString() {
        return "User003{" +
                "id=" + id +
                ", age=" + age +
                ", s=" + s +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getS() {
        return s;
    }

    public void setS(Integer s) {
        this.s = s;
    }

    /**
     * Builder for instances of type {@link User003}
     */
    public static final class Builder {
        private Long id;
        private Integer age;
        private Integer s;

        /**
         * Set the value of the field id of the target instance of type {@link User003}
         */
        public Builder id(final Long id) {
            this.id = id;
            return this;
        }

        /**
         * Set the value of the field age of the target instance of type {@link User003}
         */
        public Builder age(final Integer age) {
            this.age = age;
            return this;
        }

        /**
         * Set the value of the field s of the target instance of type {@link User003}
         */
        public Builder s(final Integer s) {
            this.s = s;
            return this;
        }

        /**
         * Create a new instance of type {@link User003}
         */
        public User003 build() {
            return new User003(this);
        }
    }
}
