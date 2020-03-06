package ljtao.springaop.mycode;

import ljtao.springaop.mycode.service.Test;
import ljtao.springaop.mycode.service.UserService;

/**
 * @author ljtao3 on 2020/3/6
 */
public class TestMain {
    public static void main(String[] args) {
        new TestMain().fun1();
    }
    /*
        测试自己手写的springaop
     */
    public void fun1(){

        //模拟容器初始化
        ApplicationContext ac=new ApplicationContext();
        Test test = (Test)ApplicationContext.proxyBeanMap.get("test");
        test.doWithProxy();
        System.out.println("==========");
        test.doWithNotProxy();

        UserService userService = (UserService)ApplicationContext.proxyBeanMap.get("userservice");
        System.out.println(userService.doWithProxy(1));
        System.out.println(userService.doWithProxy(2));
        System.out.println(userService.doWithNotProxy(3));
    }
}
