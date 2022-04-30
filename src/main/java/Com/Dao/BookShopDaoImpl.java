package Com.Dao;
import Com.Exception.BookStockException;
import Com.Exception.UserAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class BookShopDaoImpl implements BookShopDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int findPriceByIsbn(String isbn) {
        String sql="select price from book where isbn= ?";
        return jdbcTemplate.queryForObject(sql,Integer.class,isbn);
    }

    @Override
    public void updateStock(String isbn){
        //对书的库存进行检查，不足则抛出异常
        String sql2="select stock from book_stock where isbn= ? ";
        Integer stock=jdbcTemplate.queryForObject(sql2,Integer.class,isbn);
        if(stock <=0) {
            throw new BookStockException("库存不足....");
        }
        String sql="update book_stock set stock=stock-1 where isbn= ? ";
        jdbcTemplate.update(sql,isbn);
    }

    @Override
    public void updateUserAccount(String username, Integer price){
        //检查余额是否充足，若不足，则抛出异常
        String sql2="select balance from account1 where username= ? ";
        Integer balance=jdbcTemplate.queryForObject(sql2,Integer.class,username);
        if(balance<price){
            throw new UserAccountException("余额不足...");
        }
        String sql="update account1 set balance=balance - ? where username= ? ";
        jdbcTemplate.update(sql,price,username);
    }
}
