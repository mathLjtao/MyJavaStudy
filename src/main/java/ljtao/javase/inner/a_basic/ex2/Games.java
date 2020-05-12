package ljtao.javase.inner.a_basic.ex2;

import javax.swing.plaf.synth.SynthScrollBarUI;

/**
 * @author ljtao3 on 2020/5/8
 * Java编程思想中的例子。（内部类章节）
 */
interface Game{ boolean move();}
interface GameFactory{Game getGame();}
class Checkers implements  Game{
    private int move=0;
    private final  static int MOVES=3;
    @Override
    public boolean move() {
        System.out.println("Checkers move "+move);
        return ++move!=MOVES;
    }
    public static GameFactory factory=new GameFactory(){
        @Override
        public Game getGame() {
            return new Checkers();
        }
    };
}
class Chess implements  Game{
    private int move=0;
    private final  static int MOVES=4;
    @Override
    public boolean move() {
        System.out.println("Chess move "+move);
        return ++move!=MOVES;
    }
    //Java8 Lambda 表达式,运用函数式接口
    public static GameFactory factory=()->new Chess();
}
public class Games {
    public static void palyGame(GameFactory factory){
        Game s=factory.getGame();
        while (s.move());
    }

    public static void main(String[] args) {
        palyGame(Checkers.factory);
        palyGame(Chess.factory);
    }
}
