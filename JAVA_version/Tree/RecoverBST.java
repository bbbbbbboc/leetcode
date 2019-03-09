// 99. Recover Binary Search Tree

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
    TreeNode n1 = null;
    TreeNode n2 = null;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    
    public void recoverTree(TreeNode root) {
        traverse(root);
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
    }
    
    private void traverse(TreeNode root) {
        if (root == null)
            return;
        
        traverse(root.left);
        
        if (n1 == null && prev.val >= root.val)
            n1 = prev;
        if (n1 != null && prev.val >= root.val)
            n2 = root;
        prev = root;
        
        traverse(root.right);
    }
}