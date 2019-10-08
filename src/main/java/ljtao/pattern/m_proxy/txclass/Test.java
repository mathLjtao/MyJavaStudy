package ljtao.pattern.m_proxy.txclass;

import java.lang.reflect.Constructor;

public class Test {

    public static void main(String[] args) throws  Exception{
        /*
        Object o = ProxyUtil.newProxyInstance(new UserDaoImpl());
        UserDao userDao=(UserDao) o;
        userDao.print("dd");
        */
        demo();
    }
    //
    public static void demo()throws  Exception{
        Class<?> aClass = Class.forName("ljtao.pattern.m_proxy.txclass.$Proxy");
        //通过某个构造方法，new一个对象出来
        Constructor<?> constructor = aClass.getConstructor(Class.forName("ljtao.pattern.m_proxy.txclass.UserDao"));
        Object o = constructor.newInstance(new UserDaoImpl());
        ((UserDao)o).print("dd");
    }

}
