// 114. Flatten Binary Tree to Linked List

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
    
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        
        TreeNode oldLeft = root.left;
        TreeNode oldRight = root.right;
        
        flatten(oldLeft);
        flatten(oldRight);
        
        root.right = oldLeft;
        root.left = null;
        TreeNode curr = root;
        while (curr.right != null)
            curr = curr.right;
        curr.right = oldRight;
    }
}