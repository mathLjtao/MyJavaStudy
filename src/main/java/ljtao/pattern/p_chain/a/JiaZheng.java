package ljtao.pattern.p_chain.a;

public class JiaZheng extends Player{
    public JiaZheng(Player  nextPlayer){
        setSuccessor(nextPlayer);
    }
    @Override
    public void handle(int i) {
        if(i==3){
            System.out.println("花到贾政，贾政作诗！");
        }
        else{
            System.out.println("通过贾政");
            next(i);
        }
    }
}
