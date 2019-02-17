package Algorithm;

import java.util.Arrays;
/**
	给定一个数组 求排序后相邻两个数的最大差值 要求时间复杂度O(N) 使用非比较排序

*/
public class MaxGap {

	public static int maxGap(int[] nums) {
		if (nums == null || nums.length < 2) {
			return 0;
		}
		int len = nums.length;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		//遍历待排序数组 找出最大 最小值
		for (int i = 0; i < len; i++) {
			min = Math.min(min, nums[i]);
			max = Math.max(max, nums[i]);
		}
		if (min == max) {
			return 0;
		}
		//准备对应的桶(个数比数组长度多一个)
		boolean[] hasNum = new boolean[len + 1];
		int[] maxs = new int[len + 1];
		int[] mins = new int[len + 1];
		int bid = 0; //桶下标
		
		//遍历数组 每个桶中记录范围内的最大值 最小值 和 数组中是否有值的boolean标记
		for (int i = 0; i < len; i++) {
			bid = bucket(nums[i], len, min, max);
			mins[bid] = hasNum[bid] ? Math.min(mins[bid], nums[i]) : nums[i];
			maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], nums[i]) : nums[i];
			hasNum[bid] = true;
		}
		//循环 比较当前桶min 与 前一个非空桶的max 差值
		int res = 0;
		int lastMax = maxs[0];
		for (int i = 1; i <= len; i++) {
			if (hasNum[i]) {
				res = Math.max(res, mins[i] - lastMax);
				lastMax = maxs[i];
			}
		}
		return res;
	}

	//将对应的数字放到对应的桶中
	public static int bucket(long num, long len, long min, long max) {
		return (int) ((num - min) * len / (max - min));
	}


}
