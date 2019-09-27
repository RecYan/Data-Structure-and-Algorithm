package Algorithm.Array;

import java.util.Arrays;

//数组中最接近k的两个数
public class TwoSumLessThanK {


    public static int[] twoSumLessThanK(int[] nums, int k) {

        if(nums == null || nums.length < 0) {
            return null;
        }

        Arrays.sort(nums);

        int[] res = new int[2];

        int L = 0;
        int R = nums.length - 1;
        int max = Integer.MIN_VALUE;

        while(L < R) {
            if(nums[L] + nums[R] > k) {
                R--;
            } else {
                max = Math.max(max, res[L] + res[R]);
                res[0] = nums[L];
                res[1] = nums[R];
                L++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4 ,5};
        int k = 4;
        int[] res = twoSumLessThanK(nums, k);
        for(int i : res) {
            System.out.print(i + " ");
        }
    }

}
