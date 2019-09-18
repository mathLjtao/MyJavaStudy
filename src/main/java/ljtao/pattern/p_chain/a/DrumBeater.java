package ljtao.pattern.p_chain.a;

public class DrumBeater {
    private static Player player;
    public static void main(String[] args){
        //创建责任链
        player=new JiaMu(new JiaShe(new JiaZheng(null)));
        //规定由第二个人处理请求
        player.handle(2);

        JiaMu jm=new JiaMu(null);
        jm.test();
    }
}
