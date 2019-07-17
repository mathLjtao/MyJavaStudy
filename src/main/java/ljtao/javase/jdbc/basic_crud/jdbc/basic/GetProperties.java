package ljtao.javase.jdbc.basic_crud.jdbc.basic;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class GetProperties {
    public static void main(String[] args) throws  Exception{
        InputStream in = new FileInputStream("D:\\workspaces\\MyJavaStudy\\src\\main\\java\\ljtao\\javase\\jdbc\\basic_crud\\jdbc\\basic\\db.properties");
        Properties properties = new Properties();
        //加载配置文件
        properties.load(in);
        //获取配置文件中的数据
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        System.out.println(driver);
    }
}
