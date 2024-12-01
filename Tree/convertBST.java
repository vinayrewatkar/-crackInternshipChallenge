class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return solve(0, nums, nums.length - 1);
    }
    
    public TreeNode solve(int left, int[] nums, int right) {
        // Base case: no more elements to process
        if (left > right) {
            return null;
        }
        
        // Find the middle element and make it the root
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        
        // Recursively build the left and right subtrees
        node.left = solve(left, nums, mid - 1);
        node.right = solve(mid + 1, nums, right);
        
        return node;
    }
}
