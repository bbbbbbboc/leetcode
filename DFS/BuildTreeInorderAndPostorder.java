// 106. Construct Binary Tree from Inorder and Postorder Traversal

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(0, inorder.length - 1, 0, postorder.length - 1, inorder, postorder, map);
    }
    
    private TreeNode helper(int inStart, int inEnd, int postStart, int postEnd, int[] inorder, int[] postorder, Map<Integer, Integer> map) {
        
        if (inStart > inEnd || postStart > postEnd)
            return null;
        
        TreeNode root = new TreeNode(postorder[postEnd]);
        int idxRootIn = map.get(postorder[postEnd]);
        
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == postorder[postEnd]) {
                idxRootIn = i;
                break;
            }
        }
        
        root.left = helper(inStart, idxRootIn - 1, postStart, postStart + idxRootIn - inStart - 1, inorder, postorder, map);
        root.right = helper(idxRootIn + 1, inEnd, postStart + idxRootIn - inStart, postEnd - 1, inorder, postorder, map);
        
        return root;
    }
}