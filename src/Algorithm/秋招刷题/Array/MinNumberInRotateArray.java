package Algorithm.Array;

/**
 *  定义把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 *  例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1
 */
public class MinNumberInRotateArray {


    public static int minNumberInRotateArray(int[] num) {

        if(num.length == 0) {
            return 0;
        }
        if(num.length == 1) {
            return num[0];
        }

        int start = 0;
        int end = num.length - 1;

        while(start < end) {
            int mid = start + (end - start)/2; //防止溢出
            //eg [3,4,5,6,0,1,2]、[6,4]此时最小数字一定在mid的右边。
            if(num[mid] > num[end]) {
                start = mid + 1;
            } else if (num[mid] < num[end]) {
                // eg [2,2,3,4,5,6,6]、[4,6],此时最小数字一定就是array[mid]或者在mid的左边
                end = mid;
            } else {
                //eg [1,0,1,1,1] ，此时最小数字不好判断在mid左边还是右边
                end = end -1;
            }
        }
        return num[start];
    }

    public static void main(String[] args) {
        //int[] num = {3,4,5,6,0,1,2};
        //int[] num = {2,2,3,4,5,6,6};
        int[] num = {1,2,1,1,1};
        //int[] num = {1,2,3,4,5};
        System.out.println(minNumberInRotateArray(num));
    }




}
