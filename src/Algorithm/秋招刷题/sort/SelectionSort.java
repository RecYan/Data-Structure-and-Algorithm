package Algorithm.sort;

/**
 * Created by Yan_Jiang on 2019/5/16.
 */
public class SelectionSort {

    public static int[] selectionSort(int[] arr) {

        for(int i=0; i<arr.length; i++) {
            int minIndex = i;
            // i+1 - n 中寻找最小的下标
            for(int j=i+1; j<arr.length; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
            /*arr[minIndex] = arr[minIndex] ^ arr[i];
            arr[i] = arr[minIndex] ^ arr[i];
            arr[minIndex] = arr[minIndex] ^ arr[i];*/
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 4, 2, 3,7, 6,10,9};
        int[] arrSort = selectionSort(arr);
        for(int i : arrSort) {
            System.out.print(i+" ");
        }
    }

}
