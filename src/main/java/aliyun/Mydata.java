package aliyun;

public class Mydata {
    private int id;
    private String name;
    private String ser;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSer() {
        return ser;
    }

    public void setSer(String ser) {
        this.ser = ser;
    }

    @Override
    public String toString() {
        return "Mydata{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ser='" + ser + '\'' +
                '}';
    }
}
