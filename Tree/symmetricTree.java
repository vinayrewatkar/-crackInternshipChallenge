class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true; // A null tree is symmetric
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return true; // Both subtrees are null, so they are symmetric
        if (t1 == null || t2 == null)
            return false; // One subtree is null, the other isn't
        if (t1.val != t2.val)
            return false; // Values of the nodes don't match
        // Check if left subtree of t1 mirrors right subtree of t2 and vice versa
        return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }
}
