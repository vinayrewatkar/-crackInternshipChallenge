class Pair {
    int i;
    int j;
    Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
    Pair() {}
}

class Solution {
    public int uniquePathsIII(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Pair start = new Pair();
        Pair end = new Pair();
        int emptyCells = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    start.i = i;
                    start.j = j;
                }
                if (grid[i][j] == 2) {
                    end.i = i;
                    end.j = j;
                }
                if (grid[i][j] == 0) {
                    emptyCells++;
                }
            }
        }

        // Include start cell as part of the path
        return solve(start.i, start.j, end.i, end.j, grid, emptyCells + 1);
    }

    public int solve(int startI, int startJ, int endI, int endJ, int[][] grid, int remaining) {
        // Base Case: Reached end cell
        if (startI == endI && startJ == endJ) {
            return remaining == 0 ? 1 : 0;
        }

        // Boundary and obstacle check
        if (startI < 0 || startI >= grid.length || startJ < 0 || startJ >= grid[0].length || grid[startI][startJ] == -1) {
            return 0;
        }

        // Mark the cell as visited
        int temp = grid[startI][startJ];
        grid[startI][startJ] = -1;

        // Explore all four directions
        int top = solve(startI - 1, startJ, endI, endJ, grid, remaining - 1);
        int left = solve(startI, startJ - 1, endI, endJ, grid, remaining - 1);
        int right = solve(startI, startJ + 1, endI, endJ, grid, remaining - 1);
        int down = solve(startI + 1, startJ, endI, endJ, grid, remaining - 1);

        // Backtrack: Unmark the cell
        grid[startI][startJ] = temp;

        return top + left + right + down;
    }
}
