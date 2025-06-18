package spring.core_basic.member;

/**
 * @author rua
 */
public class Member {
    private Long id;
    private String name;
    private Grade grade;

    public Member(Grade grade, String name) {
        this.grade = grade;
        this.name = name;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
