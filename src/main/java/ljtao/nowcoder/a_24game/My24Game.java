package ljtao.nowcoder.a_24game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class My24Game {
    public static void main(String[] args) {
        mytest1();
    }
    //
    public static void  mytest1(){
        System.out.print("游戏开始：");
        System.out.println(setGameSum().toString());
        Scanner scanner=new Scanner(System.in);
        String s = "";
        while(!"q".equalsIgnoreCase(s)){
            System.out.println("--请输入 内容(q，退出)：");
            System.out.print(">");
            s=scanner.nextLine();
        }
        System.out.println("游戏结束！");
    }
    //给出4张牌
    public static List<Integer> setGameSum(){
        List<Integer> list=new ArrayList<>();
        Random random=new Random();
        for (int i=0;i<4;i++){
            list.add(random.nextInt(10)+1);
        }

        return list;
    }
}
