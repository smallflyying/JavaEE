package Com.Test;

import Com.Dao.BookShopDao;
import Com.Service.BookShopService;
import Com.Service.Cashier;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestTran {
    private BookShopDao bookShopDao=null;
    private BookShopService bookShopService=null;
    private Cashier cashier=null;

    @Before
    public void init() {
        ApplicationContext appx=new ClassPathXmlApplicationContext("jdbct.xml");
        bookShopService=appx.getBean("bookShopServiceImpl",BookShopService.class);
//        bookShopService=appx.getBean("bookShopService",BookShopService.class);
        System.out.println(bookShopService.getClass().getName());
        cashier=appx.getBean("cashier",Cashier.class);
//        cashier=appx.getBean("cashierImpl",Cashier.class);
        System.out.println(cashier.getClass().getName());
    }
    @Test
    public void testTx(){
        bookShopService.buyBook("xiaofei","1002");
    }

    @Test
    public void testCheck(){
        List<String> isbns=new ArrayList<>();
        isbns.add("1001");
        isbns.add("1002");
        cashier.checkOut("xiaofei",isbns);
    }
    @Test
    public void testCk(){
        cashier.checkOut("sss", Arrays.asList("1001","1002"));
    }
    @Test
    public void testUpdateUserAccount(){
        bookShopDao.updateUserAccount("xiaofei",200);
    }
}
