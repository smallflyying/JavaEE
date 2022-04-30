package mybatis.dao;

import mybatis.beans.Employee1;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapperDynamicSQL {

    //if标签动态查询
    public List<Employee1> getEmpsByConditionIfWhere(Employee1 Condition);

    //trim标签动态查询
    public List<Employee1> getEmpsByConditionTrim(Employee1 employee1);

    //测试choose,when,otherwise
    List<Employee1> getEmpByChoose(Employee1 employee1);

    //通过数组实现批量删除(foreach)
    int deleteMoreByArray(@Param("ids") Integer[] ids);

    //通过list集合实现批量添加
    int insertMoreByList(@Param("emps") List<Employee1> emps);
}
