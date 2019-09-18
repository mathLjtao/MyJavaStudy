package ljtao.pattern.p_chain.a;
/*
代表贾母的类代码
 */
public class JiaMu extends Player{
    //设置此对象的下家是谁
    public JiaMu(Player  nextPlayer){
       setSuccessor(nextPlayer);
    }
    /*
    关键方法，处理请求
     */
    @Override
    public void handle(int i) {
        if(i==1){
            System.out.println("花到贾母，贾母作诗！");
        }
        else{
            System.out.println("通过贾母");
            next(i);
        }
    }
    public static void test(){
        System.out.println("sss");
    }
    public static void test1(){
        test();
        System.out.println("sss");
    }
}
