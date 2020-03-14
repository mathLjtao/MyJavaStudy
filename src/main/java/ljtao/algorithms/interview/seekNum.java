package ljtao.algorithms.interview;

/**
 * @author ljtao
 * @date 2020/3/13
 */
public class seekNum {
    public static void main(String[] args) {
        fun1(15);
    }
    //自然数序列，找出任意连续之和等于n的所有子序列
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
}
