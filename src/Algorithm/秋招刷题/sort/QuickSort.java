package Algorithm.sort;

/**
 * Created by Yan_Jiang on 2019/5/16.
 */
public class QuickSort {


   /* public static int[] quickSort(int[] arr, int L, int R) {
        if(L < R) {
            swap(arr, L + (int)(Math.random() * (R-L+1)), R);
            int[] p = partition(arr, L, R);
            quickSort(arr, L, p[0]-1);
            quickSort(arr, p[1]+1, R);
        }
        return arr;
    }

    private static int[] partition(int[] arr, int L, int R) {
        int less = L -1;
        int cur = L;
        int more = R;
        while(cur < more) {
            if(arr[cur] < arr[R]) {
                less ++;
                swap(arr, less, cur);
                cur++;
            } else if (arr[cur] > arr[R]) {
                more --;
                swap(arr, more, cur);
            } else{
                cur++;
            }
        }
        *//**
         * [less num...num more]
         * *//*
        swap(arr, more, R);
        return new int[]{less+1, more-1};
    }

    private static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }*/
    public static int[] quickSort(int[] arr, int L, int R) {
        if (L < R) {
            //数组中随机选取一个数与最后一个数交换
            swap(arr, L + (int)(Math.random() * (R-L+1)), R);
            int[] p = partition(arr, L, R);
            partition(arr, L, p[0] - 1);
            partition(arr, p[1] + 1, R);
        }
        return arr;
    }

    private static int[] partition(int[] arr, int l, int r) {

        int less = l - 1;
        int cur = l;
        int more = r;

        while (cur < more) {
            if (arr[cur] < arr[r]) {
                less++;
                swap(arr, less, cur);
                cur++;
            } else if (arr[cur] > arr[r]) {
                more--;
                swap(arr, more, cur);
            } else {
                //相等
                cur++;
            }
        }
        /**
         * [less num...num more]
         * */
        swap(arr, l, r);
        return new int[]{less + 1, more - 1};
    }

    private static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }


    public static void main(String[] args) {
        int[] arr = new int[] {1, 4, 2, 3,7};
        int[] arrSort = quickSort(arr, 0, arr.length-1);
        for(int i : arrSort) {
            System.out.print(i+" ");
        }
    }
}
