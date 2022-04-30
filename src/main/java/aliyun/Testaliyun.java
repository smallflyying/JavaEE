package aliyun;

import jdbcTemplate.Employ;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class Testaliyun {
    private JdbcTemplate jdbcTemplate;
    @Before
    public void init(){
        ApplicationContext aliyun=new ClassPathXmlApplicationContext("aliyun.xml");
        jdbcTemplate=aliyun.getBean("jdbcTemplate",JdbcTemplate.class);
    }
//    @Test
//    public void testquery(){
////        String sql="select * from mydata";
////        RowMapper<Mydata> rowMapper=new BeanPropertyRowMapper<Mydata>(Mydata.class);
////        List<Mydata> query=jdbcTemplate.query(sql,rowMapper);
////        for(Mydata ee:query)
////            System.out.println(ee);
//    }
    @Test
    public void test(){

    }
}
