package mybatis.beans;

public class Employee1 {
    private Integer id;
    private String name;
    private String email;
    private Integer gender;
    private Dept de;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Dept getDe() {
        return de;
    }

    public void setDe(Dept de) {
        this.de = de;
    }

    public Employee1() {
    }

    public Employee1(Integer id, String name, String email, Integer gender) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Employee1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", did=" + de +
                '}';
    }
}
