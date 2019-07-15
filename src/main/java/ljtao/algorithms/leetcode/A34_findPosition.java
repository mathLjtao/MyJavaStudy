package ljtao.algorithms.leetcode;
/*
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
你的算法时间复杂度必须是 O(log n) 级别。
如果数组中不存在目标值，返回 [-1, -1]。

示例 1:
输入: nums = [5,7,7,8,8,10], target = 8
输出: [3,4]
示例 2:
输入: nums = [5,7,7,8,8,10], target = 6
输出: [-1,-1]
 */
public class A34_findPosition {
    public static void main(String[] args) {
        int[] nums=new int[]{5,7,7,8,8,10};
        System.out.println(searchRange(nums,5)[0]);
        System.out.println(searchRange(nums,5)[1]);
    }
    public static int[] searchRange(int[] nums, int target) {
        int[] re=new int[]{-1,-1};
        int len=nums.length;
        if(len==0)
            return re;
        for (int i=0;i<len;i++) {
            if(target>nums[i])
                return re;
            if(nums[i]==target ){
                if(re[0]==-1){
                    re[0]=i;
                    re[1]=i;
                }
                else{
                    re[1]=i;
                }
            }
        }
        return re;
    }
}
