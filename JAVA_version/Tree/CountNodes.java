// 222. Count Complete Tree Nodes
// Time: O(log(n)^2)
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
    public int countNodes(TreeNode root) {
        int h = height(root);
        if (h == -1)
            return 0;
        
        if (height(root.right) == h - 1) 
            return countNodes(root.right) + (int) Math.pow(2, h);
        else
            return countNodes(root.left) + (int) Math.pow(2, h - 1);
    }
    
    private int height(TreeNode root) {
        if (root == null)
            return -1;
        return 1 + height(root.left);
    }
}