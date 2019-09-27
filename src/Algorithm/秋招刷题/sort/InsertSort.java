package Algorithm.sort;

/**
 * Created by Yan_Jiang on 2019/5/16.
 * 手写数组 跟踪过程
 */
public class InsertSort {

    public static int[] insertSort(int[] arr) {
        for(int i=0; i<arr.length-1; i++) {
            int cur = arr[i+1]; //待排初始位置
            int preIndex = i; //已排的末尾位置
            while(preIndex>=0 && arr[preIndex] > cur) {
                //移动排好的元素,找到cur的合适下标
                arr[preIndex+1] = arr[preIndex];
                preIndex--;
            }
            //将新元素插入位置
            arr[preIndex+1] = cur;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 4, 2, 3,7, 6,10,9};
        int[] arrSort = insertSort(arr);
        for(int i : arrSort) {
            System.out.print(i+" ");
        }
    }
}
