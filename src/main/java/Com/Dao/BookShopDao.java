package Com.Dao;

public interface BookShopDao {

    //find price by isbn
    public int findPriceByIsbn(String isbn);

    //update the stock,使书号对应的库存-1
    public void updateStock(String isbn);

     //update user's account；使username的balance-price
    public void updateUserAccount(String username,Integer price);

}
