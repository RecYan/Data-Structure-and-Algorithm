package Algorithm;

import java.util.Arrays;

/**
 * Created by Yan_Jiang 
 * 插入排序
 *  时间复杂度 O(n*n)
 */
public class InsertSort {


    public static void insertSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) { //第一层，从下标1位置开始，准备插入操作(下标0位置已经排好)
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) { //比较操作 从当前插入位置 向前一次比较排序
                swap(arr, j, j+1);
            }
        }
    }


    public static void swap(int[] arr, int i, int j) {
		//位运算 交换两个数
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];

    }

    
}
