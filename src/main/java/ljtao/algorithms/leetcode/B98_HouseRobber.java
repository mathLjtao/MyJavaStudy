package ljtao.algorithms.leetcode;

import java.util.Arrays;

/*
你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。

示例 1:
输入: [1,2,3,1]
输出: 4
解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     偷窃到的最高金额 = 1 + 3 = 4 。

示例 2:
输入: [2,7,9,3,1]
输出: 12
解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 */
public class B98_HouseRobber {
    public static void main(String[] args) {
      //  int[] nums=new int[]{226,174,214,16,218,48,153,131,128,17,157,142,88,43,37,157,43,221,191,68,206,23,225,82,54,118,111,46,80,49,245,63,25,194,72,80,143,55,209,18,55,122,65,66,177,101,63,201,172,130,103,225,142,46,86,185,62,138,212,192,125,77,223,188,99,228,90,25,193,211,84,239,119,234,85,83,123,120,131,203,219,10,82,35,120,180,249,106,37,169,225,54,103,55,166,124};
        int[] nums=new int[]{2,7,9,3,1};
        System.out.println(rob1(nums));
    }
    //解题思想，对一个房子只有两种选择，1、抢；2、不抢。。这个思路很重要
    public static int rob(int[] nums) {
        int len=nums.length;
        int[] re=new int[len];
        if(len==0){
            return 0;
        }
        if (len==1){
           return nums[0];
        }
        /*
        //递归，，这个会超出时间
        int max=0;
        int sum1=rob(Arrays.copyOfRange(nums, 0, len - 2))+nums[len-1];
        int sum2=rob(Arrays.copyOfRange(nums, 0, len- 3))+nums[len-2];
        max=sum1>sum2?sum1:sum2;
        */

        re[0]=nums[0];
        re[1]=nums[0]>nums[1]?nums[0]:nums[1];
        int max=0;
        //下面这里同时比较了两个，有点多余
        for (int i = 2; i < len; i++) {
            int sum1=re[i-2]+nums[i];
            int sum2=0;
            if(i-3<0){
                 sum2=nums[i-1];
            }else{
                 sum2=re[i-3]+nums[i-1];
            }

            re[i]=sum1>sum2?sum1:sum2;
        }
        return re[len-1];
    }
    /*
    网上解法
    解题思想，对一个房子只有两种选择，1、抢；2、不抢。。这个思路很重要
     */
    public static int rob1(int[] nums) {
                //  pre1   pre2   n
        //3,9,6,4,2 , 1   ,  2  , 3
        int pre1=0;//代表n的前一个的前一个的总和
        int pre2=0;//代表n的前一个的总和
        for (int n:nums){
            int tem=pre1;
            pre1=pre2;
            //pre2 ,代表不抢；tem+n 代表抢
            pre2=Math.max(pre2,tem+n);
        }
        return pre2;
    }
    /*
    网上解法,用一个数组保存每一个屋子前面最大的偷钱数
     */
    public static int rob2(int[] nums) {
        int n = nums.length;
        if(n==0)
            return 0;
        if(n==1)
            return nums[0];
        int dp[] = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i= 2;i<n;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[n-1];
    }
}