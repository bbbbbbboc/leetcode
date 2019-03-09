// 230. Kth Smallest Element in a BST

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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        
        while (k > 0) {
            TreeNode curr = stack.pop();
            k--;
            
            if (k == 0)
                return curr.val;
            
            TreeNode nextSmall = curr.right;
            while (nextSmall != null) {
                stack.push(nextSmall);
                nextSmall = nextSmall.left;
            }
        }
        
        return -1;
    }
}