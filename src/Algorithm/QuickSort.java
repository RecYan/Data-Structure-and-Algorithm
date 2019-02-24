package Algorithm;

import java.util.Arrays;
/**
Created by Yan_Jiang 
荷兰国旗改进经典快排
	经典快排 --> 改进快排 --> 随机快排
	时间复杂度O(N*logN)
*/
public class QuickSort {

	public static void quickSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		quickSort(arr, 0, arr.length - 1);
	}

	public static void quickSort(int[] arr, int l, int r) {
		if (l < r) {
			//l + (int) (Math.random() * (r - l + 1)) --> 随机选取数组中的一个元素
			swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
			int[] p = partition(arr, l, r);
			quickSort(arr, l, p[0] - 1);
			quickSort(arr, p[1] + 1, r);
		}
	}

	/**
		改进经典快排 --> 随机快排
			随机选取数组中一个元素与数组中最后一个元素进行交换
			选取该元素值作为比较对象
			划分less区域，more区域{**区别：包括数组最后一个元素**}
			
	*/
	public static int[] partition(int[] arr, int l, int r) {
		int less = l - 1; //初始的小于区域       
		int more = r; //包括数组最后一个元素 --> 初始化大于区域
		/**
			如果遍历下标 遇到比带比较数小的数 则将该数与小于区域的后一个交换
				
		*/
		while (l < more) {
			if (arr[l] < arr[r]) {
				swap(arr, ++less, l++);
			} else if (arr[l] > arr[r]) {
				swap(arr, --more, l);
			} else {
				l++;
			}
		}
		swap(arr, more, r); //将数组最后一个元素与大于区域的第一个元素交换 还原数组
		return new int[] { less + 1, more }; //返回等于区域数组边界元素
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}


}
