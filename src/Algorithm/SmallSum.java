package Algorithm;

/**
 * Created by Yan_Jiang on 2018/9/16.
     * 小和问题
     在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。求一个数组
     的小和。
     例子：
     [1,3,4,2,5]
     1左边比1小的数，没有；
     3左边比3小的数，1；
     4左边比4小的数，1、3；
     2左边比2小的数，1；
     5左边比5小的数，1、3、4、2；
     所以小和为1+1+3+1+1+3+4+2=16
 */
public class SmallSum {

    //使用归并排序 迭代处最小和
    public static int smallSum(int[] arr) {

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
        int res = 0; //定义最小和
        int p1 = L; // 指向 左半边最小的值
        int p2 = mid + 1; //指向 右半边最小的值

        while (p1 <= mid && p2 <= R) { //未超过边界

            res += arr[p1] < arr[p2] ? (R - p2 + 1) * arr[p1] : 0; //找出右边比arr[p1]大的数有多少个

            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];  //辅助数组 那个小就存放那个
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

        int[] arr = {1, 3, 4, 2, 5};
        System.out.println(smallSum(arr));
    }
}
