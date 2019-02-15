package Algorithm;

/**
 * Created by Yan_Jiang on 
 * 递归实现寻找数组中的最大值
 */
public class Main {

    public static int getMax(int[] arr, int L, int R) {

        if(L == R) { //递归终止条件
            return arr[L];
        }

        int mid = (L + R) / 2; //中间划分 分别递归
        int leftMax = getMax(arr, L, mid);
        int rightMax = getMax(arr, mid+1, R);

        return Math.max(leftMax,rightMax);

    }

    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return mergeSort(arr, 0, arr.length - 1);
    }

    public static int mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return mergeSort(arr, l, mid) + mergeSort(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    public static int merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        int res = 0;
        while (p1 <= m && p2 <= r) {
            res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
        return res;
    }


    public static void main(String[] args) {

        int[] arr = {1, 4, 5, 2, 6};

        int max = getMax(arr, 0, arr.length - 1);
        System.out.println(max);
        int[] arr2 = {1, 3, 4, 2, 5};
        System.out.println(smallSum(arr2));
    }
}
