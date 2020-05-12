package ljtao.javase.collection.queue;

import java.util.*;

/**
 * @author ljtao3 on 2020/5/11
 * Java编程思想，PriorityQueue实例
 * 1、PriorityQueue调用offer()方法来插入一个对象时，这个对象会在队列中被排序，默认的排序将使用对象在队列中的自然排序
 */
public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
        Random random=new Random(47);
        for (int i=0;i<10;i++){
            priorityQueue.offer(random.nextInt(i+10));
        }
        printQ(priorityQueue);

        List<Integer> ints= Arrays.asList(25,22,31,2,1,45,5,4,5,7,22,567,3);
        priorityQueue=new PriorityQueue<Integer>(ints);
        printQ(priorityQueue);//1 2 3 4 5 5 7 22 22 25 31 45 567
        //倒序
        priorityQueue=new PriorityQueue<Integer>(ints.size(),Collections.reverseOrder());
        priorityQueue.addAll(ints);
        printQ(priorityQueue);//567 45 31 25 22 22 7 5 5 4 3 2 1

        String fact="MY CODE,HELLO WORLD !! ";
        List<String> strings=Arrays.asList(fact.split(""));
        PriorityQueue<String> stringPQ=new PriorityQueue<>(strings);
        printQ(stringPQ);//        ! ! , C D D E E H L L L M O O O R W Y

        stringPQ=new PriorityQueue<>(strings.size(),Collections.reverseOrder());
        stringPQ.addAll(strings);
        printQ(stringPQ);//Y W R O O O M L L L H E E D D C , ! !

        Set<Character> charSet=new HashSet<>();
        for (char c : fact.toCharArray()){
            charSet.add(c);
        }
        PriorityQueue<Character> characterPQ=new PriorityQueue<>(charSet);
        printQ(characterPQ);//  ! , C D E H L M O R W Y

    }

    static void printQ(Queue queue){
        while (queue.peek()!=null){
            System.out.print(queue.remove()+" ");
        }
        System.out.println();
    }

}
