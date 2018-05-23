// 98. Validate Binary Search Tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean helper(TreeNode root, long minRight, long maxLeft) {
        if (root == null)
            return true;
        if (root.val <= minRight || root.val >= maxLeft)
            return false;
        
        return helper(root.left, minRight, root.val) && helper(root.right, root.val, maxLeft);
    }
}