package ljtao.book_study.mybatisSourceCode.my;

import ognl.Ognl;
import org.apache.ibatis.binding.MapperProxy;
import org.apache.ibatis.builder.xml.XMLConfigBuilder;
import org.apache.ibatis.executor.SimpleExecutor;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.*;
import org.apache.ibatis.transaction.jdbc.JdbcTransaction;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Proxy;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author linjintao
 * @date 2021/7/26
 */
public class Test {


    public static void main(String[] args) throws Exception {
        fun3();
    }
    //jdbc基本查询
    public static void fun1() throws Exception {
        //1.注册驱动
        // Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        Connection conn= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?serverTimezone=UTC", "root", "root");
        Statement stm=conn.createStatement();
        String sql="select * from product";
        ResultSet rs = stm.executeQuery(sql);
        while(rs.next()){
            //获取第一二列的信息
            System.out.print(rs.getString(1));
            System.out.println(","+rs.getString(2));
        }
        if(rs!=null) rs.close();
        if(stm!=null) stm.close();
        if(conn!=null) conn.close();
    }
    public static void fun1_1() throws Exception {
        //1.注册驱动
        // Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        Connection conn= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?serverTimezone=UTC", "root", "root");

        String sql="select * from product where pid = ? and pname = ?";
        //预编译处理
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setLong(1,2);
        preparedStatement.setString(2,"BBB");
        ResultSet rs = preparedStatement.executeQuery();
        while(rs.next()){
            //获取第一二列的信息
            System.out.print(rs.getString(1));
            System.out.println(","+rs.getString(2));
        }
        if(rs!=null) rs.close();
        if(preparedStatement!=null) preparedStatement.close();
        if(conn!=null) conn.close();
    }
    //mybatis 基本查询
    public static void fun2() throws IOException {
        //读取配置
        String resource= "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //查询
        User aa = mapper.queryUserBySchoolName("u3");
        // User bb = mapper.queryUserBySchoolName("u3");
        System.out.println(aa);
    }
    //MapperProxy
    public static void fun2_1() throws Exception {
        String resource= "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        //创建代理对象
        MapperProxy<UserMapper> userMapperMapperProxy = new MapperProxy<>(sqlSession, UserMapper.class, new ConcurrentHashMap<>());
        UserMapper userMapper = (UserMapper)Proxy.newProxyInstance(UserMapper.class.getClassLoader(), new Class[]{UserMapper.class}, userMapperMapperProxy);
        User user = userMapper.queryUserBySchoolName("u3");
        System.out.println(user);
    }
    //mybatis中简单执行器（SimpleExecutor）的运行
    public static void fun2_2() throws Exception {
        String resource= "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        //解析
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(resourceAsStream);
        //存储
        Configuration configuration = xmlConfigBuilder.parse();
        Connection conn= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?serverTimezone=UTC", "root", "root");
        JdbcTransaction jdbcTransaction = new JdbcTransaction(conn);
        //执行器
        SimpleExecutor simpleExecutor = new SimpleExecutor(configuration, jdbcTransaction);
        MappedStatement ms = configuration.getMappedStatement("ljtao.book_study.mybatisSourceCode.my.UserMapper.queryUserBySchoolName");
        List<Object> objects = simpleExecutor.doQuery(ms, "u3", RowBounds.DEFAULT,
                SimpleExecutor.NO_RESULT_HANDLER, ms.getBoundSql("u3"));
        System.out.println(objects);
    }

    //ognl使用
    public static void fun3() throws Exception {
        // OgnlContext context = new OgnlContext(null,null,new DefaultMemberAccess(true));
        Map<String,Object> userMap=new HashMap<>();
        User user1=new User();
        User user2=new User();
        user1.setUserName("");
        user2.setUserName("aaa");
        userMap.put("user1",user1);
        userMap.put("user2",user2);
        // context.put("user2",user);
        Object value1 = Ognl.getValue("user2",userMap);
        Boolean value2 = (Boolean)Ognl.getValue("user1.userName!=null && user1.userName!=''",userMap);
        Boolean value3 = (Boolean)Ognl.getValue("user2.userName!=null && user2.userName!=''",userMap);
        String name = (String)Ognl.getValue("user2.userName",userMap);
        System.out.println(value1);
        System.out.println(value2);
        System.out.println(value3);
        System.out.println(name);
    }
    //jdbc3KeyGen
    public static void fun4() throws IOException {
        String resource= "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUserCode("111");
        user.setUserName("222");

        int aa = mapper.addUser(user);
        // int aa = mapper.addUser_b(user);
        sqlSession.commit();
        System.out.println(user.getUserId());
    }
    //jdbc插入语句，获取自动增长KEY实例
    public static void fun4_1() throws Exception {
        Connection conn= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?serverTimezone=UTC", "root", "root");
        Statement stm=conn.createStatement();
        String sql="INSERT INTO `sys_user` (`user_code`,`user_name`) value (\"111\",\"2223\") ";
        // stm.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
        stm.executeUpdate(sql,new String[]{"USER_ID"});
        ResultSet rs = stm.getGeneratedKeys();
        while(rs.next()){
            //获取第一二列的信息
            System.out.print(rs.getLong(1));
        }
        if(rs!=null) rs.close();
        if(stm!=null) stm.close();
        if(conn!=null) conn.close();
    }
    //selectKeyGen
    public static void fun5() throws IOException {
        String resource= "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUserCode("111");
        user.setUserName("222");

        // int aa = mapper.addUser(user);
        int aa = mapper.addUser_b(user);
        sqlSession.commit();
        System.out.println(user.getUserId());
    }
}
