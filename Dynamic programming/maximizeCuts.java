class Solution {
    // Function to find the maximum number of cuts
    public int maximizeCuts(int n, int x, int y, int z) {
        return solve(n, x, y, z);
    }

    public int solve(int n, int x, int y, int z) {
        // Base cases
        if (n == 0)
            return 0; // Successfully used entire rod
        if (n < 0)
            return Integer.MIN_VALUE; // Invalid cut

        // Try all possible cuts and find the maximum
        int cutX = 1 + solve(n - x, x, y, z);
        int cutY = 1 + solve(n - y, x, y, z);
        int cutZ = 1 + solve(n - z, x, y, z);

        // Return the maximum number of cuts
        return Math.max(cutX, Math.max(cutY, cutZ));
    }
}