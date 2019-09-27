package Algorithm.LeetCode;
/**
 *给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * 示例 1:
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *   一、摩尔投票法
 *   设置一个计数器，选定第一个值作为起始值，后面的值 如果是这个值 那么计数加一，
 *   如果不等，那么计数减一，
 *   当计数器的值为零时，选取当前值作为新值继续计数。
 *   因为众数肯定大于1/2所以最后计数器不为零的数肯定是众数
 *   二、
 *   众数是出现次数大于n/2的数字，所以排序之后中间的那个数字一定是众数
 *
 * */
public class MajorityElement {

    public static int solution(int[] nums) {
        int count = 1;
        int num = nums[0];
        for(int i=0; i<nums.length; i++) {
            if(num == nums[i]) {
                count ++;
            } else {
                count --;
                if(count == 0) {
                    num = nums[i];
                    count = 1;
                }
            }
        }
        return num;
    }

    //排序解法
    public static int solution2(int[] nums) {
        quicksort(nums,0, nums.length-1);
        return nums[nums.length / 2];
    }

    //快排
    private static void quicksort(int[] nums, int L, int R) {
        if(L < R) {
            swap(nums, L + (int)(Math.random() * (R-L+1)), R);
            int[] p = partition(nums, L, R); //[less num...num more]
            quicksort(nums, L, p[0]-1);
            quicksort(nums, p[1]+1, R);
        }

    }

    private static int[] partition(int[] nums, int L, int R) {
        int less = L -1;
        int cur = L; //比较的数
        int more = R;//选取的数
        while(cur < R) {
            if(nums[cur] < nums[R]) {
                //swap(nums, ++less, cur++);
                less ++;
                swap(nums, less, cur);
                cur ++;
            } else if(nums[cur] > nums[R]) {
                //swap(nums, --more, cur);
                more --;
                swap(nums, more, cur);
            } else {
                cur ++;
            }
        }

        //[less num...num more]
        swap(nums, more, R); //前面随机换了一次
        return new int[]{less+1, more-1}; //[less num...num more] 返回等于num的数组
    }

    private static void swap(int[] nums, int i, int r) {
        int temp = nums[i];
        nums[i] = nums[r];
        nums[r] = temp;
    }


}
