package mybatis.beans;

import java.util.List;

public class Dept {
    private Integer did;
    private String dept_name;

    private List<Employee1> emps;

    public List<Employee1> getEmps() {
        return emps;
    }

    public void setEmp(List<Employee1> emps) {
        this.emps = emps;
    }

    public Dept() {
    }

    public Dept(Integer did, String deptname) {
        this.did = did;
        this.dept_name = deptname;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String deptname) {
        this.dept_name = deptname;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "did=" + did +
                ", dept_name='" + dept_name + '\'' +
                ", emps=" + emps +
                '}';
    }
}
