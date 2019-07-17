package ljtao.javase.jdbc.basic_crud.jdbc.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTest {
    public static void main(String[] args) throws Exception{
        query();
    }
    /**
     * 创建表
     */
    public static void createTable() throws SQLException{
        String sql = "CREATE TABLE IF NOT EXISTS `user`("
                +"`id` INT UNSIGNED AUTO_INCREMENT,"
                +" `user_name` VARCHAR(100),"
                +" `user_password` VARCHAR(100),"
                +" `user_age` INT(11),"
                +"PRIMARY KEY ( `id` )"
                +")ENGINE=InnoDB DEFAULT CHARSET=utf8;";
        Connection conn = DBUtil.getConnection();
        //开启事务
        conn.setAutoCommit(false);
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.executeUpdate();
        //提交事务
        conn.commit();
        //要注意关闭连接（在实际中最好不要像这样关闭，最好标准一点）
        conn.close();
    }

    /**
     * 增加数据
     */
    public static void add() throws SQLException{
        String sql = "INSERT INTO USER (user_name,user_password,user_age) VALUES('老王','123456',18)";
        Connection conn = DBUtil.getConnection();
        conn.setAutoCommit(false);
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.executeUpdate();
        conn.commit();
        conn.close();
    }

    /**
     * 删除数据
     */
    public static void delete() throws SQLException{
        String sql = "DELETE FROM USER WHERE USER.user_name = '老王'";
        Connection conn = DBUtil.getConnection();
        conn.setAutoCommit(false);
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.executeUpdate();
        conn.commit();
        conn.close();
    }

    /**
     * 修改数据
     */
    public static void updata() throws SQLException{
        String sql = "UPDATE USER SET USER.user_name = '老李'";
        Connection conn = DBUtil.getConnection();
        conn.setAutoCommit(false);
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.executeUpdate();
        conn.commit();
        conn.close();
    }

    /**
     * 查找数据
     */
    public static void query() throws SQLException {
        String sql = "SELECT * FROM USER";
        Connection conn = DBUtil.getConnection();
        conn.setAutoCommit(false);
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        //执行查询语句并返回结果集
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            //注意：这里要与数据库里的字段对应
            String username = resultSet.getString("user_name");
            String password = resultSet.getString("user_password");
            String age = resultSet.getString("user_age");
            System.out.println(username + " " + password + " " + age);
        }
        conn.commit();
        conn.close();
    }
}