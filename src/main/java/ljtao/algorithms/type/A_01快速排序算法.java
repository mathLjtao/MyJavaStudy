package ljtao.algorithms.type;

public class A_01快速排序算法 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		// int[] array=new
		// int[]{6,1,5,4,8,3,9,12,11,11,15,14,13,25,69,47,56,74,26,78};
		int[] array = new int[] { 72, 6, 57, 88, 60, 60, 6, 1, 5, 4, 8, 3, 9,
				12, 11, 11, 15, 14, 13, 25, 69, 47, 56, 74, 26, 78 };
		System.out.println(array.length - 1);
		quicksort(array, 0, array.length - 1);
		for (int i : array) {
			System.out.print(i + ",");
		}

	}

	static void quicksort(int[] arr, int start, int end) {

		// 这个return语句很关键，
		if (end <= start) {
			return;
		}

		int flag = arr[start];
		int i;// keng
		int s = start;
		int e = end;

		while (end != start) {

			while ((arr[end] >= flag) && (end != start)) {
				end--;
			}
			while ((arr[start] <= flag) && (end != start)) {
				start++;
				System.out.println("start:" + start);
			}
			if (end != start) {
				i = arr[end];
				arr[end] = arr[start];
				arr[start] = i;
			}
		}
		if (end == start && arr[end] < flag) {
			i = arr[end];
			arr[end] = arr[s];
			arr[s] = i;
		}

		for (int a : arr) {
			System.out.print(a + ",");
		}
		System.out.println("flag:" + flag);

		quicksort(arr, s, end - 1);
		quicksort(arr, end + 1, e);
	}

}
