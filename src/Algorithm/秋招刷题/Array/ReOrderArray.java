package Algorithm.Array;

/**
 * 调整数组顺序使奇数位于偶数前面,
 *  保证奇数和奇数，偶数和偶数之间的相对位置不变[保持稳定性] -- 冒泡稳定
 *
 */
public class ReOrderArray {

    //借助辅助空间 O(n)
    public static int[] reOrderArray(int[] array) {

        if(array.length == 0 || array.length == 1){
            return array;
        }


        int[] temp = new int[array.length];
        int oddCount = 0;
        int oddbegin =0;
        //统计数组中奇数个数
        for(int i=0; i<array.length; i++) {
            if((array[i]%2) != 0) {
                oddCount++;
            }
        }

        for(int i=0; i<array.length; i++) {
            if((array[i]%2) == 1) {
                temp[oddbegin++] = array[i];
            } else {
                temp[oddCount++] = array[i];
            }
        }
        return temp;
    }

    //不借助辅助空间 O(n*nl)
    public static int[] reOrderArrayII(int[] num) {

        int begin = 0;
        int end = num.length - 1;

        while(begin < end) {
            //遇到偶数
            if(begin < end && num[begin]%2 != 0) {
                begin++;
            }
            //遇到奇数
            if(begin < end && num[end]%2 == 0) {
                end--;
            }
            //交换位置
            int temp = num[begin];
            num[begin] = num[end];
            num[end] = temp;
        }
        return num;
    }

    private static void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[j] = num[i];
        num[i] = temp;
    }

    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4, 5, 6};
        int[] result = reOrderArrayII(num);
        int[] result2 = reOrderArray(num);
        for(int i : result) {
            System.out.print(i + " ");
        }

    }

}
