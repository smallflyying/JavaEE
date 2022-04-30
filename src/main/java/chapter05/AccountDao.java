package chapter05;

import java.util.List;

public interface AccountDao {
    //添加账户
    public int addAccount(Account account);
    //更新账户
    public int updateAccount(Account account);
    //删除账户
    public int deleteAccount(int account);
    //通过id查询账户
    public Account findAccountById(int id);
    //查询所有账户
    public List<Account> findAllAccount();
    //转账
    public void transfer(String outUser,String inUser,Double money);

}
