class Solution {
    public boolean findPair(int[] arr, int x) {
        // code here
        Arrays.sort(arr); // Sort the array
        int n = arr.length;
        int i = 0, j = 1; // Two-pointer approach

        while (i < n && j < n) {
            int diff = arr[j] - arr[i];

            if (diff == x && i != j) { // Pair found
                return true;
            } else if (diff < x) { // Increase the larger pointer
                j++;
            } else { // Decrease the smaller pointer
                i++;
            }
        }
        return false; // No pair found
    }
}
