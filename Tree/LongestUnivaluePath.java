// 687. Longest Univalue Path

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
    int maxLen = 0;
    
    public int longestUnivaluePath(TreeNode root) {
        getLength(root);
        return maxLen;
    }
    
    private int getLength(TreeNode root) {
        if (root == null)
            return 0;
        
        int left = getLength(root.left);
        int right = getLength(root.right);
        
        int leftWithCurr = 0;
        int rightWithCurr = 0;
        
        if (root.left != null && root.left.val == root.val)
            leftWithCurr = left + 1;
        
        if (root.right != null && root.right.val == root.val)
            rightWithCurr = right + 1;
        
        maxLen = Math.max(maxLen, leftWithCurr + rightWithCurr);
        return Math.max(leftWithCurr, rightWithCurr);
    }
}