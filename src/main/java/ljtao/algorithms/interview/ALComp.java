package ljtao.algorithms.interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author ljtao
 * @date 2021/5/15
 * 随机插入10万个数，用ArrayList \linkedList哪个更快
 */
public class ALComp {
    public static void main(String[] args) throws Exception {
        Random random=new Random();
        List<Integer> aList=new ArrayList<>(200000);
        List<Integer> lList=new LinkedList<>();
        int[] count=new int[100000];

        for (int i = 0; i < 100000; i++) {
            int l = random.nextInt(200000);
            count[i] = l;
        }

        long c = System.currentTimeMillis();
        for (int i :count){
            aList.add(i);
        }
        System.out.println(c-System.currentTimeMillis());


        long c2 = System.currentTimeMillis();
        for (int i :count){
            lList.add(i);
        }
        System.out.println(c2-System.currentTimeMillis());

    }
}
