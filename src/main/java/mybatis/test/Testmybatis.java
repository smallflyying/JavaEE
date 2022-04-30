package mybatis.test;
import mybatis.beans.Dept;
import mybatis.beans.Employee;
import mybatis.beans.Employee1;
import mybatis.dao.DeptMapper;
import mybatis.dao.EmployeeMapper;
import mybatis.dao.EmployeeMapperDynamicSQL;
import mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Testmybatis {

    @Test
    public void test01() throws IOException {

        //读取配置文件
        String resource="mybatis-config1.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        //根据配置文件构建
        SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession= sqlSessionFactory.openSession(true);
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee=mapper.getEmployeeId(1);
            System.out.println(employee);
        }
        finally {
        }
    }

    //查询所有员工信息
    @Test
    public void testAllEmployee() throws IOException {

        //读取配置文件
        String resource="mybatis-config1.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        //根据配置文件构建
        SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession= sqlSessionFactory.openSession(true);
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            List<Employee> list=mapper.getAllEmployee();
            list.forEach(employee -> System.out.println(employee));
        }
        finally {
        }
    }

    //插入员工信息
    @Test
    public void testAddEmployee() throws IOException {

        //读取配置文件
        String resource="mybatis-config1.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        //根据配置文件构建
        SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession= sqlSessionFactory.openSession(true);
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            System.out.println(mapper.toString());
            Employee employee1=new Employee(20,"小飞","123@qq.com",1);
            int employee=mapper.addEmployee(employee1);
            System.out.println(employee1.getName2());
        }
        finally {
            sqlSession.commit();
        }
    }

    //修改数据
    @Test
    public void testUpdateEmployee() throws IOException {

        //读取配置文件
        String resource = "mybatis-config1.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //根据配置文件构建
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            System.out.println(mapper.toString());
            Employee employee = new Employee(5, "小飞飞", "123@qq.com", 1);
            int employee1 = mapper.updateEmployee(employee);
        } finally {
            sqlSession.commit();
        }
    }
    //删除数据
    @Test
    public void testDeleteEmployee() throws IOException {

        //读取配置文件
        String resource = "mybatis-config1.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //根据配置文件构建
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            System.out.println(mapper.toString());
            Integer ONE=mapper.deleteEmployee(3);
        } finally {
            sqlSession.commit();
        }
    }

    //pojo传参
    @Test
    public void testSelectEmployee() throws IOException {

        //读取配置文件
        String resource = "mybatis-config1.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //根据配置文件构建
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee=new Employee(2,"xiaolan","123@qq.com",1);
            Employee e1=mapper.selectEmployee(employee);
            System.out.println(e1);
        } finally {
            sqlSession.commit();
        }
    }
    //传输属性名
    @Test
    public void testSelectField() throws IOException {

        //读取配置文件
        String resource = "mybatis-config1.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //根据配置文件构建
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//            Employee employee=new Employee(2,"小飞","123@qq.com",1);
            Employee e1=mapper.selectField("xiaofei",1);
            System.out.println(e1);
        } finally {
            sqlSession.commit();
        }
    }
    //传参查询
    @Test
    public void testSelectEmploy() throws IOException {

        //读取配置文件
        String resource = "mybatis-config1.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //根据配置文件构建
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee e1=mapper.selectParam("xiaofei",1);
            System.out.println(e1);
        } finally {
            sqlSession.commit();
        }
    }
    //查询单行数据返回Map集合    以列的形式
    @Test
    public void testMap() throws IOException {

        //读取配置文件
        String resource = "mybatis-config1.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //根据配置文件构建
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            System.out.println(mapper);
            Map<String,Object> employeeByIdReturnMap=mapper.getEmployeeByReturnMap(4);
            for(Map.Entry<String ,Object> m: employeeByIdReturnMap.entrySet())
                System.out.println(m);
        } finally {
            sqlSession.commit();
        }
    }
    //查询多行数据返回Map集合    以行的形式
    @Test
    public void testMapGetAllEmployeeByIdReturn() throws IOException {

        //读取配置文件
        String resource = "mybatis-config1.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //根据配置文件构建
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            System.out.println(mapper);
            Map<Integer,Employee> allEmployee=mapper.getAllEmployeesReturnMap();
            System.out.println(allEmployee);
        } finally {
            sqlSession.commit();
        }
    }
    //通过id查询单行多表信息返回Map集合  1    以行的形式
    @Test
    public void testSelectMapping() throws IOException {

        //读取配置文件
        String resource = "mybatis-config1.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //根据配置文件构建
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            System.out.println(mapper);
            Employee1 employee1=mapper.selectMapping(1);
            System.out.println(employee1);
        } finally {
            sqlSession.commit();
        }
    }
    //通过id查询单行多表信息返回Map集合  2  以列的形式
    @Test
    public void testSelectMapping2() throws IOException {

        //读取配置文件
        String resource = "mybatis-config1.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //根据配置文件构建
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            System.out.println(mapper);
            Map<String, Object> employee1=mapper.selectMapping2(3);
            for(Map.Entry<String, Object> m: employee1.entrySet())
                System.out.println(m);
        } finally {
            sqlSession.commit();
        }
    }

    //通过list集合查询多表联合信息    以行的形式
    @Test
    public void testSelectAllMappingInfo() throws IOException {

        //读取配置文件
        String resource = "mybatis-config1.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //根据配置文件构建
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            System.out.println(mapper);
            List<Employee1> list=mapper.selectAllMappingInfo();
            System.out.println(list);
        } finally {
            sqlSession.commit();
        }
    }
    //通过查询所有多表联合信息返回Map集合   以列的形式
    @Test
    public void testSelectAllMappingInfo2() throws IOException {

        //读取配置文件
        String resource = "mybatis-config1.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //根据配置文件构建
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            System.out.println(mapper);
            Map<String,Employee1> allEmployee=mapper.selectAllMappingInfo2();
//            System.out.println(allEmployee);
            for(Map.Entry<String,Employee1> m1:allEmployee.entrySet())
                System.out.println(m1);
        } finally {
            sqlSession.commit();
        }
    }
    /**
     * public int getrelation(Integer id);
     */
    @Test
    public void testgetrelation() throws IOException {

        //读取配置文件
        String resource = "mybatis-config1.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //根据配置文件构建
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            System.out.println(mapper);
            Employee1 getrelation1 = mapper.getrelation(1);
            System.out.println(getrelation1);
//            System.out.println(getrelation1.getName());
        } finally {
            sqlSession.commit();
        }
    }

    //通过部门查询员工信息
    @Test
    public void testgetone2() throws IOException {

        //读取配置文件
        String resource = "mybatis-config1.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //根据配置文件构建
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        try {
            DeptMapper mapper=sqlSession.getMapper(DeptMapper.class);
            Dept dept=mapper.getone2(1001);
            System.out.println(dept);
        } finally {
            sqlSession.commit();
        }
    }

    //1.if标签动态查询
    @Test
    public void testgetEmpsByConditionIfWhere() throws IOException {

        //读取配置文件
        String resource = "mybatis-config1.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //根据配置文件构建
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        try {
            EmployeeMapperDynamicSQL mapper=sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
            Employee1 em=new Employee1();
            em.setId(2);
            em.setName("小飞");
            em.setEmail("123@qq.com");
            em.setGender(1);
            List<Employee1> e11=mapper.getEmpsByConditionIfWhere(em);
            System.out.println(e11);
        } finally {
            sqlSession.commit();
        }
    }

    //trim标签动态查询

    /**
     * 2、trim：
     *若标签中有内容时：
     *prefix|suffix：将trim标签中内容前面或后面添加指定内容
     *suffixOverrides|prefixOverrides：将trim标签中内容前面或后面去掉指定内容
     *若标签中没有内容时，trim标签也没有任何效果
     */
    @Test
    public void testgetEmpsByConditionTrim() throws IOException {

        //读取配置文件
        String resource = "mybatis-config1.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //根据配置文件构建
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        try {
            EmployeeMapperDynamicSQL mapper=sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
//            Employee1 em=new Employee1();
//            em.setId(null);
//            em.setName("xiaofei");
//            em.setEmail("123@qq.com");
//            em.setGender(1);
//            List<Employee1> e11=mapper.getEmpsByConditionTrim(em);
            List<Employee1> e11=mapper.getEmpsByConditionTrim(new Employee1(null,"xiaofei","",null));
            System.out.println(e11);
        } finally {
            sqlSession.commit();
        }
    }

    //3.choose,when,otherwise,相当于if ..else if else
    //when至少有一个，otherwise最多只能有一个
    @Test
    public void testGetEmpByChooses() throws IOException {
        //读取配置文件
        String resource = "mybatis-config1.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //根据配置文件构建
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        try {
            EmployeeMapperDynamicSQL mapper=sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
            List<Employee1> list =mapper.getEmpByChoose(new Employee1(null,"","",null));
            System.out.println(list);
        } finally {
            sqlSession.commit();
        }
    }

    // 4.foreach
    //collection:设置需要循环的数组或集合
    //item：表示数组或集合中的每一个数据
    //separator：循环体之间的分隔符
    //open：foreach 标签所循环的所有内容的开始符
    //close：foreach标签所循环的所有内容的结束符
    @Test
    public void testDeleteMoreByArray() throws IOException {
        //读取配置文件
        String resource = "mybatis-config1.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //根据配置文件构建
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        try {
            EmployeeMapperDynamicSQL mapper=sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
            int result=mapper.deleteMoreByArray(new Integer[]{9,10,11});
            System.out.println(result);
        } finally {
            sqlSession.commit();
        }
    }

    //foreach 的插入操作
    @Test
    public void testInsertMoreByList(){
        SqlSession sqlSession= SqlSessionUtils.getSqlSession();
        EmployeeMapperDynamicSQL mapper=sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
        Employee1 emp1=new Employee1(null,"a1","123@qq.coom",1);
        Employee1 emp2=new Employee1(null,"a2","123@qq.coom",1);
        Employee1 emp3=new Employee1(null,"a3","123@qq.coom",1);
        Employee1 emp4=new Employee1(null,"a4","123@qq.coom",1);
        List<Employee1> list=Arrays.asList(emp1,emp2,emp3,emp4);
        System.out.println(mapper.insertMoreByList(list));
    }

    //5.sql标签
    //设置SQL片段：<sql id="empColumns">id,name,email,gender</sql>
    //引用SQL片段：<include refid="empColumns"></include>
}
