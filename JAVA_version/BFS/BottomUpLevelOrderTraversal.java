// 107. Binary Tree Level Order Traversal II

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(root, 0, ans);
        return ans;
    }
    
    private void helper(TreeNode root, int level, List<List<Integer>> ans) {
        if (root == null)
            return;
        if (level >= ans.size())
            ans.add(0, new ArrayList<>());
        
        helper(root.left, level + 1, ans);
        helper(root.right, level + 1, ans);
        
        ans.get(ans.size() - level - 1).add(root.val);
    }
}