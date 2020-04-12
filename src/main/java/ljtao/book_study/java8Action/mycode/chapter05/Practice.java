package ljtao.book_study.java8Action.mycode.chapter05;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

/**
 * @author ljtao
 * @date 2020/4/12
 */


public class Practice {
    private static Trader raoul = new Trader("Raoul", "Cambridge");
    private static Trader mario = new Trader("Mario","Milan");
    private static Trader alan = new Trader("Alan","Cambridge");
    private static Trader brian = new Trader("Brian","Cambridge");

    private static List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );
    public static void main(String[] args) {
        //fun1();
        //fun2();
        //fun3();
        //fun4();
        //fun5();
        //fun6();
        //fun7();
        fun8();
    }
    //找出2011年发生的所有交易，并按交易额排序（从低到高）。
    static void  fun1(){
        transactions.stream().filter(t->t.getYear()==2011).sorted(comparing(Transaction::getValue))
                .collect(toList()).forEach(System.out::println);

    }
    //(2) 交易员都在哪些不同的城市工作过？
    static void  fun2(){
        Map<String, List<Trader>> map = transactions.stream().map(tr -> tr.getTrader()).distinct()
                .collect(groupingBy(t -> t.getCity()));
        //{Milan=[Trader:Mario in Milan], Cambridge=[Trader:Brian in Cambridge, Trader:Raoul in Cambridge, Trader:Alan in Cambridge]}
        System.out.println(map);

        //答案
        List<String> cities =
                transactions.stream()
                        .map(transaction -> transaction.getTrader().getCity())
                        .distinct()
                        .collect(toList());
        //Cambridge,Milan
        cities.forEach(System.out::println);
    }
    //(3) 查找所有来自于剑桥的交易员，并按姓名排序。
    static void  fun3(){
        transactions.stream().map(tr->tr.getTrader()).distinct()
                .filter(trader->"Cambridge".equals(trader.getCity()))
                .sorted((a,b)->a.getName().compareTo(b.getName()))
                .collect(toList()).forEach(System.out::println);

        //答案
        List<Trader> traders =
                transactions.stream()
                        .map(Transaction::getTrader)
                        .filter(trader -> trader.getCity().equals("Cambridge"))
                        .distinct()
                        .sorted(comparing(Trader::getName))
                        .collect(toList());
        System.out.println(traders);


    }
    //(4) 返回所有交易员的姓名字符串，按字母顺序排序。
    static void  fun4(){
        //答案
        String traderStr =
                transactions.stream()
                        .map(transaction -> transaction.getTrader().getName())
                        .distinct()
                        .sorted()
                        .reduce("", (n1, n2) -> n1 + n2);
        //AlanBrianMarioRaoul
        System.out.println(traderStr);
    }
    //(5) 有没有交易员是在米兰工作的？
    static void  fun5(){
        boolean b = transactions.stream().map(transaction -> transaction.getTrader())
                .anyMatch(trader -> "Milan".equals(trader.getCity()));
        System.out.println(b);

        //答案
        boolean milanBased =
                transactions.stream()
                        .anyMatch(transaction -> transaction.getTrader()
                                .getCity()
                                .equals("Milan"));
    }
    //(6) 打印生活在剑桥的交易员的所有交易额。
    static void  fun6(){
        long count = transactions.stream().filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .map(transaction -> transaction.getValue()).count();
        System.out.println(count);
    }

    //(7) 所有交易中，最高的交易额是多少？
    static void  fun7(){
        Integer max = transactions.stream().map(transaction -> transaction.getValue())
                .reduce(Integer::max).get();
        System.out.println(max);
    }
    //(8) 找到交易额最小的交易。
    static void  fun8(){
        Transaction transaction = transactions.stream().reduce((a, b) -> a.getValue() < b.getValue() ? a : b).get();
        //{Trader:Brian in Cambridge, year: 2011, value:300}
        System.out.println(transaction);
    }

    /*









     */
}
