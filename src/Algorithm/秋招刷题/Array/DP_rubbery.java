package Algorithm.Array;
/**
 *  在一个数组arr中，找出一组不相邻的数字，使得最后的和最大。
 *    选和不选问题
 */
public class DP_rubbery {

    public static int helper(int[] arr) {

        int[] dp = new int[arr.length]; //状态 到下标i时的最大和

        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for(int i=2; i<arr.length; i++) {
            int a = dp[i-2] + arr[i]; //选
            int b = dp[i-1]; //不选
            dp[i] = Math.max(a, b);
        }
        return dp[arr.length -1];
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 1, 2, 5};

        System.out.println(helper(arr));
    }

}
