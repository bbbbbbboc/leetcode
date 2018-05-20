// 110. Balanced Binary Tree

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
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return height(root) != -1;
    }
    
    private int height(TreeNode root) {
        if (root == null)
            return 0;
        
        int leftH = height(root.left);
        if (leftH == -1)
            return -1;
        
        int rightH = height(root.right);
        if (rightH == -1)
            return -1;
        
        if (Math.abs(leftH - rightH) > 1)
            return -1;
        
        return 1 + Math.max(leftH, rightH);
        
    }
}