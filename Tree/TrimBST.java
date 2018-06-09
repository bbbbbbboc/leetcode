// 669. Trim a Binary Search Tree

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
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null)
            return null;
                
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        
        if (root.val >= L && root.val <= R) {
            return root;
        } else if (root.val < L) {
            return root.right;
        } else {
            return root.left;
        }
    }
    
}