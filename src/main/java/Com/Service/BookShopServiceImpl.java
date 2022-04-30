package Com.Service;
import Com.Dao.BookShopDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
//@Service("bookShopService")
// 代表将bookShopService自动注册到spring容器，这样就
//不用再在xml部署文件里面定义bean了
@Service
public class BookShopServiceImpl implements BookShopService {
    @Autowired
    private BookShopDao bookShopDao;
    //添加事物注解
    //如果不添加事务，在余额不足的情况下，库存会减，但余额不会再减
    //使用propagation 指定事务的传播行为，即当前事务方法被另外一个事务方法法调用时，如何使用事务
    //默认取值为REQUIRED，即使用调用方法的事务
    //REQUIRES_NEW另一种常见的传播行为，它表示该方法必须启动一个新事务，并在自己的事务内运行，如果有事务在运行，就应该挂起它。
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void buyBook(String username,String isbn){
        //获取书的单价
        int price=bookShopDao.findPriceByIsbn(isbn);
        //更新书的库存
        bookShopDao.updateStock(isbn);
        //更新用户的余额
        bookShopDao.updateUserAccount(username,price);
    }
}
//RequiresNew：新建事务，如果当前存在事务，把当前事务挂起；