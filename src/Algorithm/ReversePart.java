package Algorithm;

/**
 * Created by Yan_Jiang on 2018/9/16.
 * 在一个数组中，左边的数如果比右边的数大，则折两个数构成一个逆序对，请打印所有逆序对。
        例如：1, 5, 6, 3, 2的逆序对为(3,2), (5,2), (6,2), (5,3), (6,3)
 */
public class ReversePart {

    //使用归并排序 迭代处最小和
    public static int reversePart(int[] arr) {

        if(arr == null || arr.length < 2) {
            return 0;
        }

        return mergeSort(arr, 0, arr.length - 1);
    }

    //递归排序
    private static int mergeSort(int[] arr, int L, int R) {

        if(L == R) {
            return 0;
        }

        int mid = L + ((R - L) >> 1); //防止溢出

        return mergeSort(arr, L, mid) + mergeSort(arr, mid + 1, R) + merge(arr, L, R, mid);
    }

    private static int merge(int[] arr, int L, int R, int mid) {

        int[] help = new int[R - L + 1]; //同长度的辅助数组
        int i = 0;
        int res = 0; //定义逆序对个数
        int p1 = L; // 指向 左半边最小的值
        int p2 = mid + 1; //指向 右半边最小的值

        while (p1 <= mid && p2 <= R) { //未超过边界
            if(arr[p1] <= arr[p2]) { //左 < 右
                help[i++] = arr[p1++];
            } else { // 左 > 右 出现逆序对 -- 处理左半边
                for (int j = p1; j <= mid; j++) {
                    System.out.print("(" + arr[j] + "," + arr[p2] + "), ");
                }
                res += mid - p1 + 1; // 出现的逆序对个数
                help[i++] = arr[p2++];
            }
        }

        while (p1 <= mid) { //p2越界 拼p1
            help[i++] = arr[p1++];
        }
        while (p2 <= R) { //p1越界 拼p2
            help[i++] = arr[p2++];
        }

        //复制会整个help数组 到 arr数组

        for (int j = 0; j <help.length ; j++) {
            arr[L + j] = help[j];
        }

        return res;
    }

    //****************************** test *****************
    public static void main(String[] args) {

        int[] arr = {1, 5, 6, 3, 2};
        System.out.println(reversePart(arr));
    }
}
