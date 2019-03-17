package Algorithm.AlgorithmSloution;

/**
 * Created by Yan_Jiang on 2019/3/17.
 * 随机快排
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
            swap(arr, l + (int) (Math.random() * (r - l + 1)), r); //取数组中随机的一个数 并将该数与数组左后一个位置元素交换
            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[1] + 1, r);
        }
    }

    public static int[] partition(int[] arr, int L, int R) {
        int less = L - 1;
        int more = R; //少使用了一个变量 --> 大于区域包括了最后一个数
        while (L < more) {
            if (arr[L] < arr[R]) { //小于num --> 将该数与小于区域下一个位置元素交换 并右扩小于区域 移动指针
                swap(arr, ++less, L++);
            } else if (arr[L] > arr[R]) { //大于num --> 将该数与大于区域前一个位置元素交换 并左扩小于区域
                swap(arr, --more, L);
            } else {
                L++; //等于num --> 跳过 移动指针
            }
        }
        swap(arr, more, R); //将最后的元素与大于区域第一个位置元素交换
        return new int[] { less + 1, more }; //返回等于区域的下标[less+1:开启位置的下标， more:结束位置下标]
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }



}
