package ljtao.pattern.m_proxy.txclass;


public class UserLogProxy implements UserDao {
    private UserDao userDao;
    public  UserLogProxy(UserDao userDao){
        this.userDao=userDao;
    }
    @Override
    public void print(String name) {
        System.out.println("log");
        userDao.print(name);
    }
}
