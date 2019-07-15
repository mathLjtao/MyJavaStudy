package ljtao.algorithms.type;
/**
 * 归并排序：将待排序的数列分成若干个长度为1的子数列，然后将这些数列两两合并；
 * 得到若干个长度为2的有序数列，再将这些数列两两合并；
 * 得到若干个长度为4的有序数列，再将它们两两合并；直接合并成一个数列为止。 	
 * @author ljtao3
 *
 */
public class MergeSort {
	public static void merge(int[] a, int start, int end){
		int mid=(start+end)/2;
		int[] zArr=new int[end-start+1];//临时数组
		int zLen=0;
		int as=start;//第一数组的开始位置
		int bs=mid+1;//第二个数组的开始位置
		//只要有一组数据还没全部排完，就继续排
		while(as<=mid && bs<=end){
			if(a[as]<=a[bs])
				zArr[zLen++]=a[as++];
			else
				zArr[zLen++]=a[bs++];
		}
		//有一组排好了，另一组还没排完的继续排
		while(as<=mid)
			zArr[zLen++]=a[as++];
		while(bs<=end)
			zArr[zLen++]=a[bs++];
		
		for (int i = 0; i < zArr.length; i++) 
			a[start+i]=zArr[i];
		
	}
	public static void mergeSortUp2Down(int[] a,int start,int end){
		if(a==null || start>=end)
			return;
		int mid=(start+end)/2;
		mergeSortUp2Down(a,start,mid);//递归排序a[start...mid]
		mergeSortUp2Down(a,mid+1,end);
		merge(a,start,end);
	}

    public static void main(String[] args) {
    	 int i;
         int a[] = {80,30,60,40,90,20,10,50,70};

         System.out.printf("before sort:");
         for (i=0; i<a.length; i++)
             System.out.printf("%d ", a[i]);
         System.out.printf("\n");

         mergeSortUp2Down(a, 0, a.length-1);        // 归并排序(从上往下)
         //mergeSortDown2Up(a);                    // 归并排序(从下往上)

         System.out.printf("after  sort:");
         for (i=0; i<a.length; i++)
             System.out.printf("%d ", a[i]);
         System.out.printf("\n");
        
    }
}
