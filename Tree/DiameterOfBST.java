// 543. Diameter of Binary Tree

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
    int maxDiameter = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return maxDiameter;
    }
    
    private void helper(TreeNode root) {
        if (root == null)
            return;
        int curr = 1 + getLongestLength(root.left) + 1 + getLongestLength(root.right);
        maxDiameter = Math.max(maxDiameter, curr);
        
        helper(root.left);
        helper(root.right);
    }
    
    private int getLongestLength(TreeNode root) {
        if (root == null)
            return -1;
        return 1 + Math.max(getLongestLength(root.left), getLongestLength(root.right));
    }
}