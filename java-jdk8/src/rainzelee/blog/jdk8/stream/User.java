package rainzelee.blog.jdk8.stream;

/**
 * @description:
 * @productName: java-core-base
 * @author: LYZ
 * @date: 2021/1/20 14:03
 */
public class User {

    private String name;
    private Integer age;


    public User( Integer age,String name) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
