package ljtao.algorithms.type.greedy;

import java.util.Arrays;

public class Example {
    public static void main(String[] args) {
        int[] g=new int[]{5, 10, 2, 9, 15, 9};
        int[] s=new int[]{6, 1, 20, 3, 8};
        findContentChildren(g,s);
    }
    /*

        糖果分给孩子的问题，
        每个孩子获得大于等于某个值的糖果就会开心，
        一定数量的糖果，分给一定数量的孩子，求最多孩子开心的解法。
        解法思路：两个数组排序后，将最大糖果分给需求最大的孩子，依次递减，此个糖果不满足，就找下个需求小的孩子。
     */
    public static int findContentChildren(int[] g, int[] s){
        //g为糖果,s为孩子
        Arrays.sort(g);
        Arrays.sort(s);
        int gi=g.length-1;//记录糖果的序号
        int si=s.length-1;//记录糖果
        int res=0;
        while (gi>0 && si>0){
            if(g[gi]>=s[si]){
                res++;
                gi--;
                si--;
            }else{
                si--;
            }
        }
        System.out.println(res);
        return res;
    }
}
