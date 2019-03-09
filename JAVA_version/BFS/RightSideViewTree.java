// 199. Binary Tree Right Side View

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helper(root, 0, ans);
        return ans;
    }
    
    private void helper(TreeNode root, int depth, List<Integer> ans) {
        if (root == null)
            return;
        if (depth == ans.size())
            ans.add(root.val);
        
        helper(root.right, depth + 1, ans);
        helper(root.left, depth + 1, ans);
    }
}