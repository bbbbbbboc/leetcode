// 124. Binary Tree Maximum Path Sum

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
    int maxVal = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        maxPathDown(root);
        return maxVal;
    }
    
    private int maxPathDown(TreeNode root) {
        if (root == null)
            return 0;
        
        int left = Math.max(0, maxPathDown(root.left));
        int right = Math.max(0, maxPathDown(root.right));
        
        maxVal = Math.max(maxVal, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}