package ljtao.javase.jdbc.basic_crud.jdbc.my_test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class jdbcTest {
    public static void query(){

    }
    public static void main(String[] args) {
        Connection conn=null;
        try{
            conn =  DBUtil.getConnection();
            //开启事务
            conn.setAutoCommit(false);
            PreparedStatement state = conn.prepareStatement("select * from city");
            ResultSet resultSet = state.executeQuery();
            while(resultSet.next()){
                System.out.println(resultSet.getString("city_name"));
            }
            //提交事务
            conn.commit();
            conn.close();
        }
        catch (Exception e){

        }
    }
}
