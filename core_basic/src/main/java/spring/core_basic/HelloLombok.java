package spring.core_basic;

import lombok.Getter;
import lombok.Setter;

/**
 * @author rua
 */
@Getter
@Setter
public class HelloLombok {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "이름: " + this.name + "\n나이: " + this.age;
    }
    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("Lombok");
        helloLombok.setAge(18);
        System.out.println(helloLombok.getName());
        System.out.println(helloLombok.getAge());
        System.out.println(helloLombok.toString());
    }
}
