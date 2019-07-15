package ljtao.algorithms.leetcode;

import java.util.*;

public class A15_3Sum {
    public static void main(String[] args) {
       int[] nums=new int[]{7,-10,7,3,14,3,-2,-15,7,123,23,-7,56,456,43,-675,-6,-23,-67,-8,-45,-34,5,89,32,454,76,12,56,34,24,22,44,33,-22,-44,-55,-1,-7,6,-5,-1,3,-13,6,-15,-10,14,8,5,-10,-1,1,1,11,6,8,5,-4,0,3,10,-12,-6,-2,-6,-6,-10,8,-5,12,10,1,-8,4,-8,-8,2,-9,-15,14,-11,-1,-8,5,-13,14,-2,0,-13,14,-12,12,-13,-3,-13,-12,-2,-15,4,8,4,-1,-6,11,11,-7,-12,-2,-8,10,-3,-4,-6,4,-14,-12,-5,0,3,-3,-9,-2,-6,-15,2,-11,-11,8,-11,8,-7,8,14,-5,4,10,3,-1,-15,10,-6,-11,13,-5,1,-15};
       // int[] nums=new int[]{-1, 0, 1, 2, -1, -4};
        long time=System.currentTimeMillis();
        System.out.println(threeSum4(nums));
        System.out.println(System.currentTimeMillis()-time);
    }

    public static List<List<Integer>> threeSum1(int[] nums) {
            return null;
    }
    /*
    网上解法，看这个学习比较好
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            if(nums[i]>0)
                break;
            int first = i + 1;
            int last = length - 1;
            while (first < last) {
                int sum = nums[i] + nums[first] + nums[last];
                if (sum == 0) {
                    lists.add(Arrays.asList(nums[i], nums[first], nums[last]));
                    /*
                        这个first++,last--,
                        如果我们当前匹配成功的话,为了避免重复,当前的两个搭档肯定是不能用的
                        所以这里first++,last--
                        当然你只写first++或者last--也是可以的,不过时间上可能会慢点
                     */
                    first++;
                    last--;
                    // 如果当前first和上一个我们已经匹配过first相等 first++
                    while (first < last && nums[first] == nums[first - 1])
                        first++;
                    // 如果当前last和上一个我们已经匹配过的last相等,last--
                    while (first < last && nums[last] == nums[last + 1])
                        last--;
                } else if (sum > 0&&first<last) {
                    last--;
                } else if (sum < 0 && first < last) {
                    first++;
                }
            }
        }
        return lists;
    }

    /*
    看过网上的解法后，自己重新写的程序
     */
    public static List<List<Integer>> threeSum4(int[] nums){
        List<List<Integer>> zList=new ArrayList<>();
        Arrays.sort(nums);
        int len=nums.length;
        for (int i=0;i<len-2;i++){
            int first=i+1;
            int last=len-1;
            if(i!=0 && nums[i]==nums[i-1])
                continue;
            if(nums[i]>0)
                break;
            while(first<last){
                int sum=nums[i]+nums[first]+nums[last];
                if(sum==0){
                    zList.add(Arrays.asList(nums[i],nums[first],nums[last]));
                    first++;
                    last--;
                    while(first<last && nums[first]==nums[first-1])
                        first++;
                    while(first<last && nums[last]==nums[last+1])
                        last--;
                }
                else if(sum>0){
                    last--;
                    while(first<last && nums[last]==nums[last+1])
                        last--;
                }
                else{
                    first++;
                    while(first<last && nums[first]==nums[first-1])
                        first++;
                }
            }
        }
        return zList;
    }
    /*
    自己做的，暴力解法，，
    但是会超出时间限制
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set=new HashSet<>();
        Integer min;
        int[] intArr=new int[3];
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i <nums.length ; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(i==j)
                    continue;
                for (int k = 0; k < nums.length; k++) {
                    if( i==k || j==k)
                        continue;
                    if(nums[i]+nums[j]+nums[k]==0){
                        intArr[0]=nums[i];intArr[1]=nums[j];intArr[2]=nums[k];
                        if(intArr[0]>intArr[1]){
                            min=intArr[0];
                            intArr[0]=intArr[1];
                            intArr[1]=min;
                        }
                        if(intArr[1]>intArr[2]){
                            min=intArr[1];
                            intArr[1]=intArr[2];
                            intArr[2]=min;
                        }
                        if(intArr[0]>intArr[1]){
                            min=intArr[0];
                            intArr[0]=intArr[1];
                            intArr[1]=min;
                        }
                        list.add(intArr[0]);
                        list.add(intArr[1]);
                        list.add(intArr[2]);
                        set.add(list);
                        list=new ArrayList<>();
                    }

                }
            }
        }
        List<List<Integer>> zList=new ArrayList<>();
        for(List l:set){
            zList.add(l);
        }
        return zList;
    }
}
