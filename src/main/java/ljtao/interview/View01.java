package ljtao.interview;

/**
 * @author ljtao
 * @date 2020/3/13
 * 面试中职信（广东）
 */
public class View01 {
    public static void main(String[] args) {
        fun2();
    }


    /*
    自然数序列，找出任意连续之和等于n的所有子序列
    最后一道算法题，有点可惜，最后想出来的时候，那边的人过来收卷了。当时应该尝试一下，跟那个收卷人说，“我现在想出方法了，只是还没写，能不能给我点时间。”，
    看她给不给一个机会，没写出来真的好可惜，这里应该被扣了一些分。
    以后做试题的时候，尽量把握好时间，写快点。
     */
    public static  void fun1(int n){
        int p=0;
        int e=n/2+1;
        int sum=0;
        StringBuffer sb=new StringBuffer("");
        StringBuffer sumsb=new StringBuffer("");
        for (int i = 1; i < e; i++) {
            p=i;
            sum=0;
            while(p<=e){
                sum=p+sum;
                p++;
                if(sum>n){
                    sumsb=new StringBuffer("");
                    continue;
                }
                else if (sum==n){
                    sb.append(sumsb+String.valueOf(p-1));
                }else{
                    sumsb.append(p-1);
                }
            }
        }
        System.err.println(sb.toString());
    }
    /*
        一些不太知道结果的题
     */
    public static void fun2(){
        int i1=10,i2=10;
        System.err.println("i1+i2="+i1+i2);//i1+i2=1010
        //System.err.println("i1+i2="+i1-i2);
        System.err.println("i1+i2="+i1/i2);//i1+i2=1
        System.err.println("i1+i2="+i1*i2);//i1+i2=100


        double i3=12-11.9;
        double i4=0.1;
        double i5=0.1;
        System.out.println(i3==i4);//false
        System.out.println(i4==i5);//true
        System.out.println(12-11.9==0.1);//false
        System.out.println();

        View view=new View01().new View();
        view.method1(null);//string
        view.method2(12-11.9);//class java.lang.Double

        String str1=new String("abc");
        String str2=new String("abc");
        StringBuffer sb1=new StringBuffer("abc");
        StringBuffer sb2=new StringBuffer("abc");

        //String 的euqals方法是有重写过的，是比较内容
        System.out.println(str1.equals(str2));//true
        //StringBuffer 还是调用Object的equals，所以是用 ==
        System.out.println(sb1.equals(sb2));//false
    }

    class View{
        public void method1(Object object){
            System.out.println("object");
        }
        public void method1(String string){
            System.out.println("string");
        }
        public void method2(Object object){
            System.out.println(object.getClass().toString());
        }
    }
}
