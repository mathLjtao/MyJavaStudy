package ljtao.algorithms.leetcode;

import java.util.Arrays;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
你可以假设 nums1 和 nums2 不会同时为空。

示例 1:
nums1 = [1, 3]  nums2 = [2]
则中位数是 2.0
示例 2:
nums1 = [1, 2]	nums2 = [3, 4]
则中位数是 (2 + 3)/2 = 2.5
 * @author ljtao3
 *
 */
public class A04_Median {
	public static void main(String[] args) {
		
		System.out.println(findMedianSortedArrays(new int[]{1,2,3},new int[]{4,5,6}));
		
	}
	/**
	 * 用java的api来排序
	 */
	public static  double findMedianSortedArrays2(int[] nums1, int[] nums2) {
		int n1=nums1.length;
		int n2=nums2.length;
		if(n1==0&&n2==0){
			return 0;
		}
		int[] arr=Arrays.copyOf(nums1, nums1.length+nums2.length);
		// 1.将要复制的数组  2.从将要复制的数组的第几个元素开始  3.目标数组   4.将要放到目标数组的起始位置   5.复制多少个元素
		System.arraycopy(nums2, 0,arr,nums1.length, nums2.length);
		Arrays.sort(arr);
		if(arr.length%2==0){
			return (double)(arr[arr.length/2]+arr[(arr.length/2)-1])/2;
		}
		else{
			return arr[arr.length/2];
		}
	}
	/**
	 * 
	 */
	public static  double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int n1=nums1.length;
		int n2=nums2.length;
		int i=0,j=0,k=0;
		if(n1==0&&n2==0){
			return 0;
		}
		int[] arr=new int[n1+n2];
		while(i<n1 && j<n2){
			if(nums1[i]<nums2[j]){
				arr[k]=nums1[i];
				k++;
				i++;
			}
			else if(nums1[i]==nums2[j]){
				arr[k]=nums1[i];
				k++;
				i++;
				arr[k]=nums2[j];
				k++;
				j++;
			}
			else{
				arr[k]=nums2[j];
				k++;
				j++;
			}
		}
		System.out.println("i="+i+",j="+j);
		//有可能一个数组已经全部排完，另一个还没完成
		while(i<n1 || j<n2){
			if(i<n1){
				arr[k++]=nums1[i++];
			}
			if(j<n2){
				arr[k++]=nums2[j++];
			}
		}
		System.out.println(k);
		if(arr.length%2==0){
			return (double)(arr[arr.length/2]+arr[(arr.length/2)-1])/2;
		}
		else{
			return arr[arr.length/2];
		}
    }
}
