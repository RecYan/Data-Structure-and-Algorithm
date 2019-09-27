package Algorithm.DP;

/**
 * 两个字符串中最长公共子序列(子序列不要求连续)
 * dp[i][j] -- 表示子串A[0...i]（数组长度为n）和子串B[0...j]（数组长度为m）的最长公共子序列
 *
 * 当A[i] == B[j]时，dp[i][j] = dp[i-1][j-1] + 1;
 *
 * 否则，dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
 *
 * 最优解为dp[n-1][m-1];
 */
public class LCS_Sequence {

    public static int LCS_sequence(String str1, String str2) {

        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n+1][m+1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = 0;
            }
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                //找到相同字符 看前面的
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    //找出两串中最长的lcs
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }

    //最长公共字符串
    public static int LCS_sequenceII(String str1, String str2) {

        if(str1 == null || str2 == null) {
            return -1;
        }
        int n = str1.length();
        int m = str2.length();
        int maxLen = 0;
        int count = 0;
        int i=0;
        int j=0;

        while(i<n && j<m) {
            if(str1.charAt(i) == str2.charAt(j)) {
                count++;
                maxLen = Math.max(maxLen, count);
                i++;
                j++;
            } else {
                count = 0;
                i++;
                j++;
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String str1 = "abcd";
        String str2 = "abce";
        //System.out.println(LCS_sequence(str1, str2));
        System.out.println(LCS_sequenceII(str1, str2));
    }

}
