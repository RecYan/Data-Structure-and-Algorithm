package Algorithm.DP;

public class MaxSquare {

    public static int maxSquare(int[][] matrix) {

        int m = matrix.length; //行
        if(m < 1) {
            return -1;
        }
        int  n = matrix[0].length; //列

        int[][] dp = new int[m+1][n+1];

        int max = 0;

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <=n; j++) {
                dp[i][j] = 0;
            }
        }

        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(matrix[i-1][j-1] == 1) {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max * max;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1, 0, 0},
                          {1, 0, 1, 1, 1},
                          {1, 1, 1, 1, 1},
                          {1, 0, 0, 1, 0}};

        System.out.println(maxSquare(matrix));
    }

}
