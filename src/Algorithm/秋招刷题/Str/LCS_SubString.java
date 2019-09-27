package Algorithm.Str;

/**
 * 两个字符串中最长公共子串
 * dp[i][j] -- 表示以str1[i]和str2[j]为结尾的最长公共子串
 *
 * 当str1[i] == str2[j]时，dp[i][j] = dp[i-1][j-1] + 1;
 *
 * 否则，dp[i][j] = 0;
 *
 * 最优解为max(dp[i][j]),其中0<=i<len1, 0<=j<len2;

 */
public class LCS_SubString {

    public static int LCS_subString(String str1, String str2) {

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
                    //不同则不连续 不取
                    dp[i][j] = 0;
                }
            }
        }

        int max = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (dp[i][j] > max) {
                    max = dp[i][j];
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        String str1 = "abcd";
        String str2 = "abdde";
        System.out.println(LCS_subString(str1, str2));
    }
}
