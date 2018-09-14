package Algorithm;

/**
 * Created by Yan_Jiang on 2018/9/14.
 * 选择排序
 *   时间复杂度 O(n*n)
 */
public class SelectSort {

    public static void selectSort(int[] arr) {

        if(arr == null || arr.length < 2 ) {
            return;
        }

        for(int i=0; i<arr.length-1; i++) { // 0--N-1
            int minIndex = i; //带比较值的坐标
            for(int j=i+1; j<arr.length; j++) { // 1--N-1，一次类推
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }

    }

    public static void swap(int[] arr, int i, int j) {

        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
