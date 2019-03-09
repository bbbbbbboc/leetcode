// 545. Boundary of Binary Tree

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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        
        if (!isLeaf(root))
            ans.add(root.val);
        
        TreeNode tn = root.left;
        
        // add left boundary
        while (tn != null) {
            if (!isLeaf(tn))
                ans.add(tn.val);
            
            if (tn.left != null) {
                tn = tn.left;
            } else {
                tn = tn.right;
            }
        }
        
        // add all leaves 
        addLeaves(root, ans);
        tn = root.right;
        Stack<Integer> stack = new Stack<>();
        
        // add right boundary, in reverse order
        while (tn != null) {
            if (!isLeaf(tn))
                stack.push(tn.val);
            
            if (tn.right != null) {
                tn = tn.right;
            } else {
                tn = tn.left;
            }
        }
        
        while (!stack.empty()) {
            ans.add(stack.pop());
        }
        
        return ans;
    }
    
    private boolean isLeaf(TreeNode tn) {
        return tn.left == null && tn.right == null;
    }
    
    private void addLeaves(TreeNode root, List<Integer> res) {
        if (isLeaf(root)) {
            res.add(root.val);
        } else {
            if (root.left != null)
                addLeaves(root.left, res);
            if (root.right != null)
                addLeaves(root.right, res);
        }
    }
}