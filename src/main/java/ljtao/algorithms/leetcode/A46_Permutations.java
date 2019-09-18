package ljtao.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;
/*
给定一个没有重复数字的序列，返回其所有可能的全排列。
示例:
输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

    下面的解法：网上称作“见缝插针法”
 */
public class A46_Permutations {
    public static void main(String[] args) {
        permute(new int[]{1,2,3,4} );
    }
    /*
    将元素依次从不同位置上插入，得到不同的结果
     */
    public static List<List<Integer>> permute(int[] nums) {
        if(nums==null || nums.length<1){
            return null;
        }
        List<List<Integer>> reList=new ArrayList<List<Integer>>();
        //将数组中的元素，一个一个加进去
        for(int i=0;i<nums.length;i++){
            if(i==0){
                reList=add(null,nums[i]);
            }
            else{
                reList=add(reList,nums[i]);
            }
        }
        return reList;
    }
    //加入一个元素，改变原来的集合
    private  static  List<List<Integer>> add(List<List<Integer>> numList ,Integer num){

        if(numList==null || numList.size()<1){
            List<List<Integer>> newNumList=new ArrayList<List<Integer>>();
            List<Integer> list=new ArrayList<>();
            list.add(num);
            newNumList.add(list);
            return newNumList;
        }
        List<List<Integer>> newNumList=new ArrayList<List<Integer>>();
        for(List<Integer> l:numList){
            for(int i=0;i<=l.size();i++){
                List<Integer> newL= new ArrayList<>();
                //这里要用深拷贝，将集合中的元素搬到一个新的集合，要不然元素会一直堆积起来，循环终止不了
                newL.addAll(l);
                newL.add(i,num);
                newNumList.add(newL);
            }
        }
        return newNumList;
    }
}
