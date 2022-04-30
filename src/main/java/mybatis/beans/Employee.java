package mybatis.beans;

public class Employee {
    private Integer id1;
    private String name2;
    private String email2;
    private Integer gender2;

    public Employee() {
    }

    public Employee(Integer id1, String name2, String email2, Integer gender2) {
        this.id1 = id1;
        this.name2 = name2;
        this.email2 = email2;
        this.gender2 = gender2;
    }

    public Integer getId1() {
        return id1;
    }

    public void setId1(Integer id1) {
        this.id1 = id1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public Integer getGender2() {
        return gender2;
    }

    public void setGender2(Integer gender2) {
        this.gender2 = gender2;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id1=" + id1 +
                ", name2='" + name2 + '\'' +
                ", email2='" + email2 + '\'' +
                ", gender2=" + gender2 +
                '}';
    }
}
