package ljtao.algorithms.leetcode;

import java.util.Arrays;

/*
给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

示例 1:
给定 nums = [3,2,2,3], val = 3,
函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
你不需要考虑数组中超出新长度后面的元素。

示例 2:
给定 nums = [0,1,2,2,3,0,4,2], val = 2,
函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 */
public class A27_removeElement {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int val=2;
        System.out.println(removeElement1(nums,val));
    }

    public static int removeElement(int[] nums, int val) {
        int start=0;
        for (int i=0;i<nums.length;i++){
            //有相同的就让一个数加一
            if (nums[i]==val){
                start++;
                continue;
            }
            //减掉有多少个相同的数
            nums[i-start]=nums[i];
        }
        System.out.println(Arrays.toString(nums));
        return nums.length-start;
    }
    //网上做法，跟自己做的差不多
    public static int  removeElement1(int[] nums,int elem) {
        int begin=0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]!=elem)
                nums[begin++]=nums[i];
        }
        System.out.println(Arrays.toString(nums));
        return begin;
    }
}
