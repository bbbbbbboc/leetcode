// 105. Construct Binary Tree from Preorder and Inorder Traversal

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }
    
    private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart >= preorder.length || inStart > inEnd) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[preStart]);
        
        int rootInorderIdx = 0;
        
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[preStart]) {
                rootInorderIdx = i;
                break;
            }
        }
        
        root.left = helper(preStart + 1, inStart, rootInorderIdx - 1, preorder, inorder);
        root.right = helper(preStart + rootInorderIdx - inStart + 1, rootInorderIdx + 1, inEnd, preorder, inorder);
        
        return root;
    }
}