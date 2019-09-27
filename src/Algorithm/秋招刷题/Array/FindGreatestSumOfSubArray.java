package Algorithm.Array;

/**
 * 给一个数组，返回它的最大连续子序列的和
 *    eg: {6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 算法时间复杂度O（n）
 * 用total记录累计值，maxSum记录和最大
 * 基于思想：
 *           对于一个数A，若是A的左边累计数非负，那么加上A能使得值不小于A，认为累计值A对
 *           整体和是有贡献的。如果前几项累计值负数，则认为有害于总和，total记录当前值。
 *           此时 若和大于maxSum 则用maxSum记录下来
 */
public class FindGreatestSumOfSubArray {

    public static int findGreatestSumOfSubArray(int[] num) {

        if (num == null || num.length <= 0) {
            return -1;
        }
        int curSum = num[0];//当前和
        int maxSum = num[0]; //存储最大和，不能初始为0，存在负数

        //从下标1开始
        for (int i = 1; i < num.length; i++) {
            if (curSum < 0) {
                curSum = num[i]; //将当前和改为现在的num[i]
            } else {
                curSum = curSum + num[i];
            }
            // 存储最大结果
            if (curSum > maxSum) {
                maxSum = curSum;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] num = {-3, 6, -2, 7, -15, 1, 2, 2};
        System.out.println(findGreatestSumOfSubArray(num));
    }

}
