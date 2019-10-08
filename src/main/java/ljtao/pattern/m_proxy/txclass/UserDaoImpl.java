package ljtao.pattern.m_proxy.txclass;

public class UserDaoImpl implements UserDao {

    @Override
    public void print(String name) {
        System.out.println("name:"+name);
    }
}
