package ljtao.algorithms.type.dynamic_programming;

/*
    动态规划
    将原问题拆解成若干个子问题，同时保存子问题的解，使得每个子问题只求解一次，最终获得原问题的答案
 */
public class C_动态规划 {
    public static void main(String[] args) {
        int n=35;
        C_动态规划 c1=new C_动态规划();
        c1.meno=new long[n+1];
        long l1 = System.currentTimeMillis();
        System.out.print(fib(n));
        long l2 = System.currentTimeMillis();
        System.out.println("   耗时："+(l2-l1));
        System.out.print(c1.fib1(n));
        long l3 = System.currentTimeMillis();
        System.out.println("   耗时："+(l3-l2));
        System.out.print(fib2(n));
        long l4 = System.currentTimeMillis();
        System.out.println("   耗时："+(l4-l3));
        System.out.println(System.getProperty("java.version"));
    }
    /*
    F(0)= 1 ,f(1)=1,F(n)=F(n-1)+F(n-2)
    斐波那契数列
    */
    public static int fib(int n){
        if(n==0|| n==1)
            return 1;
        return fib(n-1)+fib(n-2);
    }
    /*
    记忆法搜索，自上向下的解决问题
     */
    private long[] meno;
    public  long fib1(int n){
        if(n==0|| n==1)
            return 1;
        if(meno[n]==0){
            meno[n]=fib1(n-1)+fib1(n-2);
        }
        return meno[n];
    }
    /*
    动态规划法：自下向上的解决问题
     */
    public static long fib2(int n){
        long[] myMeno=new long[n+1];
        myMeno[0]=1;
        myMeno[1]=1;
        for (int i=2;i<=n;i++){
            myMeno[i]=myMeno[i-1]+myMeno[i-2];
        }
        return myMeno[n];
    }

}
