class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        if (m == 0)
            return 0; // Special case: empty needle

        for (int i = 0; i <= n - m; i++) { // Ensure `i + m` does not exceed `haystack.length`
            int j = 0;
            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i; // Found the needle
            }
        }

        return -1; // Needle not found
    }
}
