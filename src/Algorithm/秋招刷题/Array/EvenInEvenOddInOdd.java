package Algorithm.Array;

public class EvenInEvenOddInOdd {

    public static int[] evenInEvenoddInOdd(int[] arr) {
        if (arr == null || arr.length < 2) {
            return null;
        }
        int even = 0;  // 指向偶数的位置
        int odd = 1;   // 指向奇数的位置
        // 发货点：每次把最后一个数根据它是奇数还是偶数和前面对应奇偶指针上的数互换位置
        int end = arr.length - 1;
        while (odd < arr.length-1 && even < arr.length-1) {
            if (arr[end] % 2 == 0) {
                // 往even指针上发货,然后even指针后移两位
                swap(arr, end, even);
                even += 2;
            } else {
                // 往odd指针上发货,然后odd指针后移两位
                swap(arr, end, odd);
                odd += 2;
            }
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4, 5, 6};
        int[] result = evenInEvenoddInOdd(num);
        for(int i : result) {
            System.out.print(i + " ");
        }
    }

}
