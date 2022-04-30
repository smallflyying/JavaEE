package Com.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("cashier")
//@Service
public class CashierImpl implements Cashier{

    @Autowired
    private BookShopService bookShopService=null;

    //一次买几本书
    @Transactional
    @Override
    public void checkOut(String username, List<String> isbns) {
         for(String isbn:isbns){
             bookShopService.buyBook(username,isbn);
         }
    }

}
