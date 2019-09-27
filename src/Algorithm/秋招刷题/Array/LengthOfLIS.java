package Algorithm.Array;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度
 */
public class LengthOfLIS {


    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n;i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(lengthOfLIS(nums));

        *//*int[] nums = {1,2,1,3,4};
        System.out.println(lengthOfLIS(nums));*//*
    }*/


    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        //长度为dp[i]的LIS
        int[] dp = new int[n];

        int maxLen = 0;
        for(int i=0; i<n; i++) {
            dp[i] = 1;
            for(int j=0; j<i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            maxLen = Math.max(dp[i], maxLen); //找出dp[i]中最大的数
        }
        return maxLen;
    }

}
