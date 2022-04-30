package mybatis.dao;

import mybatis.beans.Employee;
import mybatis.beans.Employee1;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {

    //查询单个员工信息
    Employee getEmployeeId(Integer id1);

    //查询所有员工信息
    List<Employee> getAllEmployee();

    //插入数据
     int addEmployee(Employee employee);

     //修改数据
    public int  updateEmployee(Employee employee1);

    //删除数据
    public int deleteEmployee(Integer id1);

    //传输pojo
    public  Employee selectEmployee(Employee employee);

    //传输属性名
    public Employee selectField(@Param("name")String name2, @Param("gender") Integer gender2);

    //传参查询
    public Employee selectParam(@Param("name") String name2,Integer gender2);

    //上周实验
    //查询单行数据返回Map集合
    public Map<String ,Object> getEmployeeByReturnMap(Integer id1);

    //查询多行数据返回Map集合
    @MapKey("id1")
    public Map<Integer,Employee> getAllEmployeesReturnMap();

    //通过id查询多表信息    方式一
    public Employee1 selectMapping(Integer id);

    //通过id查询多表信息  方式二
    public Map<String ,Object> selectMapping2(Integer id);

    //查询多表信息
    List<Employee1> selectAllMappingInfo();

    //查询多表信息返回Map集合
    @MapKey("id")
    public Map<String,Employee1> selectAllMappingInfo2();

    //根据员工id对多表联合查询
    public Employee1 getrelation(Integer id);


}
