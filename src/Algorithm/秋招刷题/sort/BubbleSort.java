package Algorithm.sort;

/**
 * Created by Yan_Jiang on 2019/5/16.
 */
public class BubbleSort {

    public static int[] bubbleSort(int[] arr) {

        if(arr.length <= 0) {
            return new int[]{0};

        }
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr.length-1-i; j++) {
                if(arr[j+1] < arr[j]) {
                    /*int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;*/
                    arr[j+1] = arr[j+1] ^ arr[j];
                    arr[j] = arr[j+1] ^ arr[j];
                    arr[j+1] = arr[j+1] ^ arr[j];
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 4, 2, 3,7};
        int[] arrSort = bubbleSort(arr);
        for(int i : arrSort) {
            System.out.print(i+" ");
        }
    }
}
