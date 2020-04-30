package ljtao.dataStructure.sort;

import java.util.Arrays;

/**
 * @author ljtao
 * @date 2020/3/27
 */
public class QuickSort {
    public static void main(String[] args) {
        //int[] arr={5,2,4,3,7,1,8,6};
        //int[] arr={2,2};
        int[] arr={6,6,6,5,6,6,6,6,5,6};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr){
        segmentation(arr,0,arr.length-1);
    }
    //先创建一个中分方法，将数组的第一个数，插入到数组的中间，左边的小，右边的大
    private static void segmentation(int[] arr,int start,int end){
        if(start>=end){
            return ;
        }
        int middle=start;
        int last=end;
        while(end>start){
            /*
            从尾部开始。
            因为找到的数要跟第一个位置交换，如果从左边先找，就会找到比第一个数大的位置停下，后面交换过去就不符合逻辑。
            所以要从右边开始，找到比第一个数小的位置先停下。
             */
            while(arr[middle]<arr[end] && start<end){
                --end;
            }
            while(arr[middle]>=arr[start] && start<end){
                ++start;
            }
            if (end>start){
                int s=arr[end];
                arr[end]=arr[start];
                arr[start]=s;
            }
            else if (end==start && arr[end]<arr[middle]){
                int s=arr[middle];
                arr[middle]=arr[start];
                arr[start]=s;
            }
        }

        //将中间数两边的数组，继续递归
        segmentation(arr,middle,start-1);
        segmentation(arr,start+1,last);

    }

}
