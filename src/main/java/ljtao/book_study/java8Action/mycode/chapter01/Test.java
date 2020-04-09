package ljtao.book_study.java8Action.mycode.chapter01;

import java.io.File;

/**
 * @author ljtao3 on 2020/4/8
 */
public class Test {
    public static void main(String[] args) {

    }
    public static void fun1(){
        //一个点，表示当前目录，两个. 表示上级目录
        File[] files = new File(".").listFiles();
        for(File file:files){
            System.out.println(file.getName());
        }

        File file = new File("..");
        System.out.println(file.getName());
    }
}
