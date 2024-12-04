class Solution {
    public int knightDialer(int n) {
        int MOD = 1_000_000_007;

        // Possible knight moves
        int[][] moves = {
                { -2, -1 }, { -2, 1 }, // Up-left, Up-right
                { -1, -2 }, { -1, 2 }, // Left-up, Right-up
                { 1, -2 }, { 1, 2 }, // Left-down, Right-down
                { 2, -1 }, { 2, 1 } // Down-left, Down-right
        };

        // Initialize the previous DP state
        int[][] prev = new int[4][3];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (!isInvalidKey(i, j)) {
                    prev[i][j] = 1; // Base case: 1 way to be at (i, j) with 1 move
                }
            }
        }

        // Perform DP for n moves
        for (int step = 2; step <= n; step++) {
            int[][] curr = new int[4][3];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 3; j++) {
                    if (!isInvalidKey(i, j)) {
                        // Calculate the number of ways for the current position
                        for (int[] move : moves) {
                            int ni = i + move[0];
                            int nj = j + move[1];
                            if (!isInvalidKey(ni, nj)) {
                                curr[i][j] = (curr[i][j] + prev[ni][nj]) % MOD;
                            }
                        }
                    }
                }
            }
            prev = curr; // Move to the next step
        }

        // Sum up all valid positions
        int result = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (!isInvalidKey(i, j)) {
                    result = (result + prev[i][j]) % MOD;
                }
            }
        }
        return result;
    }

    private boolean isInvalidKey(int i, int j) {
        return (i < 0 || j < 0 || i >= 4 || j >= 3 || (i == 3 && j != 1));
    }
}
