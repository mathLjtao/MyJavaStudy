package ljtao.algorithms.type;

public class A_02快速排序算法 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] a = new int[] { 6, 1, 5, 4, 8, 3, 9, 25, 69, 47, 56, 74, 26, 78,
				12, 11, 11, 15, 14, 13, 25, 69, 47, 56, 74, 26, 78 };
		quicksort(a, 0, a.length - 1);
		for (int i : a) {
			System.out.print(i + ",");
		}

	}

	static void quicksort(int[] a, int left, int right) {
		int i, j, t, temp;
		if (left >= right)
			return;

		temp = a[left]; // temp中存的就是基准数
		i = left;
		j = right;
		while (i != j) {
			/*
			顺序很重要，要先从右边开始找，--->
			因为找到的数要跟第一个位置交换，如果从左边先找，就会找到比第一个数大的位置停下，后面交换过去就不符合逻辑.
			所以要从右边开始，找到比第一个数小的位置先停下.
			 */
			while (a[j] >= temp && i < j)
				j--;
			// 再找右边的
			while (a[i] <= temp && i < j)
				i++;
			// 交换两个数在数组中的位置
			if (i < j) {
				t = a[i];
				a[i] = a[j];
				a[j] = t;
			}
		}
		// 最终将基准数归位
		a[left] = a[i];
		a[i] = temp;

		quicksort(a, left, i - 1);// 继续处理左边的，这里是一个递归的过程
		quicksort(a, i + 1, right);// 继续处理右边的 ，这里是一个递归的过程
	}
}
