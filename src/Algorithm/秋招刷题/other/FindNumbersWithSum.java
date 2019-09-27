package Algorithm.other;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 *
 * 思路： 滑动窗口 左右夹逼
 *
 */
public class FindNumbersWithSum {

    public static ArrayList<Integer> findNumbersWithSum(int[] num, int k) {

        if(num == null || num.length <0 || k < 0) {
            return null;
        }

        ArrayList<Integer> result = new ArrayList<>();
        int left = 0;
        int right = num.length - 1;

        while(right > left) {
            int curSum = num[left] + num[right];
            if(curSum == k) {
                result.add(num[left]);
                result.add(num[right]);
                return result;
            } else if(curSum < k) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }

    /**
     * 用HashMap存放元素和下标，然后开始遍历数组找到和为sum的两个元素，从左到右找到的第一对和为sum的就是最小的一对。
     */
    public static ArrayList<Integer> findNumbersWithSumII(int[] array, int sum) {
        HashMap map = new HashMap();
        ArrayList result = new ArrayList();
        int len = array.length;

        for (int i = 0; i < len; i++) {
            map.put(array[i], i);
        }

        for (int i = 0; i < len; i++) {
            int sub = sum - array[i];
            if (map.containsKey(sub)) {
                result.add(array[i]);
                result.add(sub);
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num = {1, 2, 4, 7, 11, 15};
        ArrayList<Integer> list = findNumbersWithSum(num, 15);
        System.out.println(list);
    }
}
