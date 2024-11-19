class Solution {
    public int findDuplicate(int[] nums) {
        boolean[] visted = new boolean[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            if (visted[nums[i]])
                return nums[i];
            visted[nums[i]] = true;
        }
        return -1;
    }
}