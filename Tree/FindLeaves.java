// 366. Find Leaves of Binary Tree

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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        height(root, ans);
        return ans;
    }
    
    private int height(TreeNode root, List<List<Integer>> ans) {
        if (root == null)
            return -1;
        
        int level = 1 + Math.max(height(root.left, ans), height(root.right, ans));
        if (level + 1 > ans.size())
            ans.add(new ArrayList<>()); 
            
        ans.get(level).add(root.val);
        return level;
    }
}