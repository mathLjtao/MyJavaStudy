package ljtao.javase.jdbc.basic_crud.jdbc.my_test;


import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    public static Connection getConnection()throws Exception{
        //加载数据库连接驱动
        Class.forName("com.mysql.jdbc.Driver") ;
        return  DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "root");

    }
}
