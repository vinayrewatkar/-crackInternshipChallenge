class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0; // Index for the next non-zero element

        // First pass: move all non-zero elements to the beginning
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }

        // Second pass: fill the remaining positions with zeros
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}