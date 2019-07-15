package ljtao.algorithms.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
	你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:
给定 nums = [2, 7, 11, 15], target = 9
因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
 */
public class A01_twoSum {
	public static void main(String[] args) {
		int[] nums={3};
		System.out.println(twoSum(nums,6));
	}
	/**
	 * 比较好的解法，利用hash的原理，一遍过
	 */
	public static int[] twoSum1(int[] nums,int target){
		Map<Integer, Integer> map = new HashMap<>();
	    for (int i = 0; i < nums.length; i++) {
	        if (map.containsKey(target - nums[i])) {
	            return new int[] { map.get(target - nums[i]), i };
	        }
	        map.put(nums[i], i);
	    }
	    throw new IllegalArgumentException("No two sum solution");
	}
	/**
	 * 自己写的
	 * 两个for循环，从1-末尾，依次加上后面的数来进行判断
	 */
	public static  int [] twoSum(int[] nums,int target){
		
		List<Integer> list=new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				System.out.println(j);
				if(nums[i]+nums[j]==target){
					list.add(i);
					list.add(j);
				}
			}
		}
		System.out.println(list.toString());
		int[] result=new int[list.size()];
		//list.toArray(new Integer[list.size()]);
		for (int i = 0; i < result.length; i++) {
			result[i]=list.get(i);
		}
		return result;
	}
}
