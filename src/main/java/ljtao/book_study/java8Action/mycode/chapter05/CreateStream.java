package ljtao.book_study.java8Action.mycode.chapter05;

import org.junit.Test;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author ljtao3 on 2020/4/13
 * 创建流的方式
 */
public class CreateStream {
    public static void main(String[] args) {

        fun4();
    }
    //由值创建流
    public static void fun1(){
        Stream<String> stringStream = Stream.of("Java 8", "Lamdbas", "In", "Action");
        stringStream.map(String::toUpperCase).forEach(System.out::println);

        //获得一个空流
        Stream.empty();
    }
    //由数组创建流
    public static void fun2(){
        int[] ints = {1, 2, 3, 5};
        IntStream stream = Arrays.stream(ints);
    }
    //由文件生成流
    public static void fun3()  {
        try(Stream<String> lines = Files.lines(Paths.get("src/main/java/ljtao/book_study/java8Action/mycode/chapter05/data.txt"), Charset.defaultCharset())) {
            //flatMap方法就是把一个流中的每个值都换成另一个流，然后把所有的流连接起来成为一个流
            //查看文件中，一直有多少个不同的单词
            long count = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct().count();
            System.out.println(count);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    /*
        创建无限流
     */
    //简单形式
    public static void fun4(){
        //   0为初始值
        Stream.iterate(0 , n->n+2).limit(10).forEach(System.out::print);// 024681012141618
        System.out.println();
        //generate方法 它接受一个Supplier<T>类型的Lambda提供新的值
        Stream.generate(Math::random).limit(4).forEach(System.out::println);
    }
    @Test
    public void fun5(){
        //斐波那契数列
        Stream.iterate(new int[]{0,1},n->new int[]{n[1],n[0]+n[1]}).limit(10)
                .forEach(nums->System.out.println(nums[0]+","+nums[1]));

    }
}
