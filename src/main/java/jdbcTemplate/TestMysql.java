package jdbcTemplate;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.ArrayList;
import java.util.List;

//重点练习:对数据库进行增，删，查，改
//
//
public class TestMysql {
    private JdbcTemplate jdbcTemplate;
    //先对数据库初始化
    @Before
    public void init(){
        ApplicationContext ap=new ClassPathXmlApplicationContext("App1.xml");
        jdbcTemplate=ap.getBean("jdbcTemplate",JdbcTemplate.class);
    }
    //进行插入操作
    @Test
    public void testinsert(){
        String sql="insert into Employ(id1,name2,email2,gender2) value(?,?,?,?)";
        jdbcTemplate.update(sql,new Object[]{"011","xiaofei","123@qq.com","1"});
    }
    //对数据库进行删除操作
    @Test
    public void testdelete(){
        String sql="delete from Employ where id1=?";
        jdbcTemplate.update(sql,"1");
    }
    //对数据库进行查询操作
    @Test
    public void testquery(){
        String sql="select * from Employ";
        RowMapper<Employ> rowMapper=new BeanPropertyRowMapper<Employ>(Employ.class);
        List<Employ> query=jdbcTemplate.query(sql,rowMapper);
        for(Employ ee:query)
            System.out.println(ee);
    }
    //对数据库批量插入操作
    @Test
    public void batchinsert(){
        String sql="insert into Employ(id1,name2,email2,gender2) value(?,?,?,?)";
        List<Object[]> batch=new ArrayList<Object[]>();
        batch.add(new Object[]{"012","l","123@qq.com",1});
        batch.add(new Object[]{"013","lg","123@qq.com",1});
        batch.add(new Object[]{"014","lh","123@qq.com",1});
        batch.add(new Object[]{"015","lhf","123@qq.com",1});
        jdbcTemplate.batchUpdate(sql,batch);
    }
    //对数据库中数据进行修改
    @Test
    public void testupdate(){
        String sql="update Employ set name2='小飞' where id1=?";
        jdbcTemplate.update(sql,"2");
    }
}
