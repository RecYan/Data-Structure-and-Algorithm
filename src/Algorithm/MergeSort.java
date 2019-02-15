package Algorithm;

import java.util.Arrays;

/**
 * Created by Yan_Jiang 
 * 归并排序
 */
public class MergeSort {

    public static void mergeSort(int[] arr) {

        if(arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    //递归实现
    private static void mergeSort(int[] arr, int L, int R) {

        if(L == R) {
            return;
        }

        //******** 推荐这种mid写法  ********
        int mid = L + ((R - L) >> 1); // int mid = (L + R) / 2 这种写法容易发生溢出，不安全
        mergeSort(arr, L, mid); //左边有序排好
        mergeSort(arr, mid + 1, R); //右边有序排好

        merge(arr, L, mid, R);

    }

    private static void merge(int[] arr, int L, int mid, int R) {

        int[] help = new int[R - L + 1]; //生成同arr大小数组
        int i = 0;
        int p1 = L; //左指针
        int p2 = mid + 1; //右指针

        while (p1 <= mid && p2 <= R) { //两边都没有越界时 --  谁小填谁 并移动指针
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        //此时 左右两边定有一个越界 所以需要拷贝另一个未越界的数组到help数组中
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }

        //整体拷贝回原arr数组
        for (int j = 0; j <help.length ; j++) {
            arr[L + j] = help[j];
        }

    }

    


}
