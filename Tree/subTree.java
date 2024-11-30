class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false; // If root is null, no subtree can exist
        }
        if (isSameTree(root, subRoot)) {
            return true; // Check if current trees are identical
        }
        // Recursively check left and right subtrees
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true; // Both trees are null, so they are identical
        }
        if (s == null || t == null || s.val != t.val) {
            return false; // Mismatch in structure or values
        }
        // Check left and right subtrees
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}
