package ljtao.book_study.head_first_design_patterns.c_decorator.mycode;

import java.io.*;

/**
 * @author ljtao3 on 2020/1/13
 */
public class TestJavaIo {
    public static void main(String[] args){


        try(
                FileInputStream fileInputStream = new FileInputStream("D:\\workspaces\\MyJavaStudy\\src\\main\\java\\ljtao\\book_study\\head_first_design_patterns\\c_decorator\\mycode\\test.txt");
                InputStream in= new BufferedInputStream(fileInputStream);
        ){
            int read ;
            while((read=in.read())!=-1){
                System.out.print((char)read);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }




    }
}
