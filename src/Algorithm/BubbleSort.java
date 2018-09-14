package Algorithm;

/**
 * Created by Yan_Jiang on 2018/9/13.
 * 冒泡排序
 *  时间复杂度 O(n*n)
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr) {

        if(arr == null || arr.length < 2) {
            return;
        }
        //循环遍历
        for (int end = arr.length - 1; end > 0; end--) { //初始外层0--N-1
            for (int i = 0; i < end; i++) { //内层除去最后一个数 再次遍历0--N-2
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }

            }
        }
    }

    public static void swap(int[] arr, int i, int j) {

        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
