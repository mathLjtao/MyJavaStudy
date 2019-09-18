package ljtao.pattern.p_chain.a;

public class JiaShe extends Player{
    public JiaShe(Player  nextPlayer){
        setSuccessor(nextPlayer);
    }
    @Override
    public void handle(int i) {
        if(i==2){
            System.out.println("花到贾赦，贾赦作诗！");
        }
        else{
            System.out.println("通过贾赦");
            next(i);
        }
    }
}
