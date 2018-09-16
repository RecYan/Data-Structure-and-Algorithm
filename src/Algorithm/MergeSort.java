package Algorithm;

import java.util.Arrays;

/**
 * Created by Yan_Jiang on 2018/9/16.
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

        while (p1 <= mid && p2 <= R) { //两边都没有越界时 --  谁小填谁
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

    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 50000;
        int maxSize = 5;
        int maxValue = 10;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            mergeSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        mergeSort(arr);
        printArray(arr);

    }


}
