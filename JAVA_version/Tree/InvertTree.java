// 226. Invert Binary Tree

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
    public TreeNode invertTree(TreeNode root) {
        mirror(root);
        return root;
    }
    
    public void mirror(TreeNode root) {
        if (root == null)
            return;
        
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        mirror(root.left);
        mirror(root.right);
    }
}