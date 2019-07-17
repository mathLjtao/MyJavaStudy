package ljtao.soft;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/*
抽选幸运用户
 */
public class LotteryDrawDemo {
    public static void main(String[] args) {
        String[] users=new String[]{"a","b","c","d","e","f"};
        int len=users.length;
        int getUserNum=6;//获取多少人出来
        Set<String> getUsers= new HashSet<>();
        Random random=new Random();
        for(;;){
            if(getUsers.size()==getUserNum)
                break;
            //用set不会出现重复的名字
            getUsers.add(users[random.nextInt(len)]);
        }
        Iterator<String> iterator = getUsers.iterator();
        System.out.print("幸运用户有：");
        while (iterator.hasNext()){
            System.out.print(iterator.next()+",");
        }
    }
}
