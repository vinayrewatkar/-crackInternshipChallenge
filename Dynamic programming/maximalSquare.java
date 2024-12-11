class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int max = 0;

        int[][] dp = new int[n + 2][m + 2];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int right = dp[i][j + 1];
                int down = dp[i + 1][j];
                int diagonal = dp[i + 1][j + 1];

                if (matrix[i][j] == '1') {
                    dp[i][j] = 1 + Math.min(Math.min(down, right), diagonal);
                    max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return max * max;
    }
}