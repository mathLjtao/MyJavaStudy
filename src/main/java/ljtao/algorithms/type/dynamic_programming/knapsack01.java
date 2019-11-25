package ljtao.algorithms.type.dynamic_programming;
/*
    背包问题：
    有一个背包，它的容量为C，现在有n种不同的物品，编号为0...n-1,其中每件物品的重量为w(i)，价值为
    v(i)。问可以向这个背包中盛放那些物品，使得在不超过背包容量的基础上，物品的总价值最大，

    解法思路：F(I,C)=MAX(F(I-1,C),V(I)+F(I-1,C-W(I)))
    I表示第几个物品
     */
public class knapsack01 {
    public static void main(String[] args) {
//        int[] w = new int[]{ 0 , 2 , 3 , 4 , 5 };
//        int[] v = new int[]{ 0 , 3 , 4 , 5 , 6 };
//        int c=8;
        int[] w = new int[]{ 1,2,3 };
        int[] v = new int[]{ 6,10,12};
        int c=5;
        System.out.println(fun3(w,v,c));
    }
    /*
    记忆法，自顶向下求解。
    wArr，物品重量的数组，
    vArr，为物品价值的数组，
    c，为背包的容量。
    解法分析，判断一件物品有没有最优结果集里面。向下依次递归。
     */
    public static int fun1(int[] wArr,int[] vArr,int c){
        int len=vArr.length;
        return bestValue(wArr,vArr,len-1,c);
    }
    private static int[][] memo=new int[6][9];
    private static int bestValue(int[] wArr, int[] vArr, int index, int c) {
        if(index<0 || c<=0){
            return 0;
        }
        if(memo[index][c]!=0){
            return memo[index][c];
        }
        //不需要加入这个物品就能取最大值了（没有在最优结果集里）。
        int res1=bestValue(wArr,vArr,index-1,c);
        int res2=0;
        if(wArr[index]<=c){
            //另一种结果，加入这件 物品，能取到最大值（在最优结果集里） 。

            res2 =vArr[index]+ bestValue(wArr, vArr, index - 1, c - wArr[index]);
        }
        memo[index][c]=Math.max(res1,res2);
        //两种结果取最大值
        return memo[index][c];
    }
    /*
    动态规划，自下向顶求解
        0,   1,  2,  3,  4,  5
    0,  0,   6,  6,  6,  6,  6
    1,  0,   6,  10, 16, 16, 16
    2,  0,   6, 10,  16, 18, 22
     */
    public static int fun2(int[] wArr,int[] vArr,int c){
        int len=vArr.length;
        if(len<=0||c<=0)
            return 0;
        if(len==1 && wArr[len-1]<=c){
            return vArr[len-1];
        }
        int[][] memo=new int[len][c+1];
        for(int i=0;i<c+1;i++){
            if (wArr[0]<=i)
                memo[0][i]=vArr[0];
        }
        for(int j=1;j<len;j++){
            for (int k=0;k<c+1;k++){
                memo[j][k]=memo[j-1][k];
                if(k-wArr[j]>=0)
                {
                    memo[j][k]=Math.max(memo[j][k],vArr[j]+memo[j-1][k-wArr[j]]);
                }
            }
        }
        return memo[len-1][c];
    }
    /*
        优化后的解法
        在空间只为c+1个元素大小的数组上进行操作
     */
    public static int fun3(int[] wArr,int[] vArr,int c){
        int len=vArr.length;
        if(len<=0||c<=0)
            return 0;
        if(len==1 && wArr[len-1]<=c){
            return vArr[len-1];
        }
        int[] memo=new int[c+1];
        for(int i=0;i<c+1;i++){
            if (wArr[0]<=i)
                memo[i]=vArr[0];
        }
        for(int j=1;j<len;j++){
            for (int k=c;k>=wArr[j];k--){
                memo[k]=Math.max(memo[k],vArr[j]+memo[k-wArr[j]]);
            }
        }
        return memo[c];
    }



}
