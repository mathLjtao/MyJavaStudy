package ljtao.javase.inner.a_basic;

/**
 * @author ljtao3 on 2020/5/8
 * Java编程思想中的例子。（内部类章节）
 */
public class Demo01 {
    private String name="ljtao";
    private int age=18;
    private static String photo="188";


    class Inner01{
        private String name="ljtao2";
        public void fun1(){
            System.out.println("使用内部类自己的属性："+name);
            System.out.println("使用外部类的属性："+Demo01.this.name);
            System.out.println(age);
        }
    }
    static class Inner02{
        private String name="ljtao2";
        public  void fun1(){
            System.out.println(name);
            //System.out.println(age);
        }
    }
    static class Inner03{
        private String name="ljtao2";
        public static void fun1(){
            //System.out.println(name);
            //System.out.println(age);
        }
    }

    public void fun1(){
        //如果不是静态方法，可以这样调用
        new Inner01().fun1();
        new Inner02().fun1();
        Inner03.fun1();
    }
    public static void main(String[] args) {

        //静态方法访问的方式
        new Demo01().new Inner01().fun1();
        new Inner02().fun1();
        Inner03.fun1();;
    }

}
