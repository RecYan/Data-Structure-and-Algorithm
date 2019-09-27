package Algorithm.Array;

import java.util.HashMap;

/**
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {

        if(nums == null || nums.length < 0) {
            return null;
        }

        int[] result = new int[2];
        //<数值， 下标>
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            int val = target - nums[i];
            //包含则返回下标
            if(map.containsKey(val)) {
                result[0] = map.get(val);
                result[1] = i;
                return result;
            } else {
                //不符合 则将数值和对应下标存于map
                map.put(nums[i], i);
            }
        }
        return result;
    }

    public static int[] twoSumII(int[] nums, int target) {

        if(nums == null || nums.length < 0) {
            return null;
        }
        int[] res = new int[2];
        int left = 0;
        int right = nums.length - 1;

        while(left != right) {
            int sum = nums[left] + nums[right];
            if(sum == target) {
                res[0] = left;
                res[1] = right;
                return res;
            } else if(sum > target) {
                right--;
            } else{
                left++;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        int[] nums= {2, 7, 11, 15};
        int[] res = twoSum(nums, 9);
        for(int i : res) {
            System.out.print(i + " ");
        }
        System.out.println();
        int[] resII = twoSumII(nums, 9);
        for(int i : resII) {
            System.out.print(i + " ");
        }
    }
}
