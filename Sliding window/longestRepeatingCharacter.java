class Solution {
    public int characterReplacement(String s, int k) {
        int max = 0;
        int maxFreq = 0;
        int l = 0;
        int r = 0;
        int n = s.length();
        int[] count = new int[26];
        while (r < n) {
            count[s.charAt(r) - 'A']++;
            maxFreq = Math.max(maxFreq, count[s.charAt(r) - 'A']);
            if (r - l + 1 - maxFreq > k) {
                count[s.charAt(l) - 'A']--;
                l++;
            }
            max = Math.max(max, r - l + 1);
            r++;
        }
        return max;
    }
}