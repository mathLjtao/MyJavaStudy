package ljtao.algorithms.leetcode;

public class A11_ContainerWithMostWater {
    public static void main(String[] args) {
        maxArea(new int[]{1,8,6,2,5,4,8,3,7});
    }
    public static int maxArea(int[] height) {
        int len=height.length;
        int min=0;
        int sum=0;
        for (int i = 0; i < len; i++) {
            int first=height[i];
            int flag=len-1;
            while(flag>i){
                if(flag!=len-1 && height[flag]<=height[flag+1]){
                    flag--;
                    continue;
                }
                min=first<height[flag]?first:height[flag];
                sum=sum>min*(flag-i)?sum:min*(flag-i);
                flag--;
            }
        }
        System.out.println(sum);
        return sum;

    }
    /*
    网上的做法，
    双指针，大的保留，小的移动
     */
    public static  int maxArea1(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }
}
