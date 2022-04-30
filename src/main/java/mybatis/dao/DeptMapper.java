package mybatis.dao;

import mybatis.beans.Dept;

public interface DeptMapper {

    //通过部门id单个查询查询
    public int getone(Integer did);

    //通过部门查询员工信息
    Dept getone2(Integer did);
}
