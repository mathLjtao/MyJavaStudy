package ljtao.algorithms.type;
/*

    堆排序的讲解说明：https://www.cnblogs.com/skywang12345/p/3602162.html

    最大堆进行升序排序的基本思想：
    ① 初始化堆：将数列a[1...n]构造成最大堆。
    ② 交换数据：将a[1]和a[n]交换，使a[n]是a[1...n]中的最大值；
    然后将a[1...n-1]重新调整为最大堆。 接着，将a[1]和a[n-1]交换，使a[n-1]是a[1...n-1]中的最大值；然后将a[1...n-2]重新调整为最大值。
    依次类推，直到整个数列都是有序的。
 */
public class B_MyHeapSort {
    //初始化堆
    static void initHeap(int[] a,int start,int end){
        //当初始化堆的某个节点时，该节点没有子节点就退出循环
        if(start<0||(start*2+1)>end)
            return ;
        int p=a[start];
        int ls=a[start*2+1];
        //当节点有左右节点时候的情况
        if(end>=start*2+2){
            int rs=a[start*2+2];
            //左节点比较大的时候
            if(ls>p && ls>rs){
                a[start]=ls;
                a[start*2+1]=p;
                initHeap(a,start*2+1,end);
            }
            //右节点比较大的时候
            else if(rs>p && rs>ls){
                a[start]=rs;
                a[start*2+2]=p;
                initHeap(a,start*2+2,end);
            }
        }else{
            //当节点只有右节点时的情况
            if(ls>p){
                a[start]=ls;
                a[start*2+1]=p;
                initHeap(a,start*2+1,end);
            }
        }
        initHeap(a,start-1,end);
    }
    static void sort(int[] a){
        int len=a.length;
        int swap;
        while(len>=1){
            initHeap(a,len/2-1,len-1);
            len--;
            swap=a[0];
            a[0]=a[len];
            a[len]=swap;
        }
    }
    //调顺序
    public static void main(String[] args) {
        int[] a=new int[]{20,30,90,40,70,110,60,10,100,50,80};
        //int[] a=new int[]{5,11,7,2,3,17};
        sort(a);
        for(int i:a){
            System.out.print(i+",");
        }
    }
}
