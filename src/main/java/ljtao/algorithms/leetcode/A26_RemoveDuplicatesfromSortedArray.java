package ljtao.algorithms.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class A26_RemoveDuplicatesfromSortedArray {
    public static void main(String[] args) {
        System.out.println(removeDuplicates1(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }
    /*
    利用treeSet
     */
    public static int removeDuplicates(int[] nums) {
        TreeSet<Integer> set=new TreeSet<>();
        for (int i:nums){
            set.add(i);
        }
        nums=new int[set.size()];
        int count=0;
        for (int  i:set) {
            nums[count]=i;
            count++;
        }
        System.out.println(Arrays.toString(nums));
        return set.size();
    }
    /*
    看了网上解法思路后，自己重写的另一种方式
     */
    public static int removeDuplicates1(int[] nums){
        if(nums==null||nums.length==0)
            return 0;
        int firstNum=nums[0];
        int j=1;
        for (int i = 1; i < nums.length; i++) {
            if(firstNum!=nums[i])
            {
                firstNum=nums[i];
                nums[j]=nums[i];
                j++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return j;
    }
    /*
    网上做法
     */
    public static int removeDuplicates2(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
