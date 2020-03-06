package ljtao.springaop.mycode.service;

/**
 * @author ljtao3 on 2020/3/6
 */
public class UserService {
    public String doWithProxy(int id){
        return "user ："+id;
    }
    public String doWithNotProxy(int id){
        return "user ："+id;
    }
}
