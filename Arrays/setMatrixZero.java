class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        Set<Integer> x = new HashSet<>();
        Set<Integer> y = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    x.add(i);
                    y.add(j);
                }
            }
        }
        for (int r : x) {
            for (int i = 0; i < m; i++) {
                matrix[r][i] = 0;
            }
        }
        for (int c : y) {
            for (int i = 0; i < n; i++) {
                matrix[i][c] = 0;
            }
        }
    }
}