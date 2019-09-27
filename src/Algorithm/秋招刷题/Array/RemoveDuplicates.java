package Algorithm.Array;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * //相等则快指针++ -->快慢指针中间会空出一个数
 * //不等则[快指针位置]覆盖[慢指针+1位置] 慢指针++
 */
public class RemoveDuplicates {

    public static  int removeDuplicates(int[] nums) {

        if(nums == null || nums.length <0) {
            return 0;
        }

        int slow = 0;
        int fast = 1;

        while (fast < nums.length)  {
            if(nums[slow] != nums[fast]) {
                nums[slow+1] = nums[fast];
                slow++;
            } else {
                fast++;
            }
        }
        return slow + 1;
    }
}
