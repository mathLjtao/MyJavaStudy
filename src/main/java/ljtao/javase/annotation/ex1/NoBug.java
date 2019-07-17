package ljtao.javase.annotation.ex1;

public class NoBug {
    @jiancha
    public void suansu(){
        System.out.println("123456789");
    }
    @jiancha
    public void jiafa(){
        System.out.println("1+1="+(1+1));
    }
    @jiancha
    public void jianfa(){
        System.out.println("1-1="+(1-1));
    }
    @jiancha
    public void chengfa(){
        System.out.println("1*1="+(1*1));
    }
    @jiancha
    public void chufa(){
        System.out.println("1/0="+(1/0));
    }
}
