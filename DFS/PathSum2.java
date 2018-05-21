// 113. Path Sum II

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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        
        helper(root, sum, new ArrayList<>(), ans);
        return ans;
    }
    
    private void helper(TreeNode root, int sum, List<Integer> path, List<List<Integer>> ans) {
        if (root == null)
            return;
        
        path.add(root.val);
        
        if (root.left == null && root.right == null && root.val == sum) {
            ans.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        
        helper(root.left, sum - root.val, new ArrayList<>(path), ans);
        helper(root.right, sum - root.val, new ArrayList<>(path), ans);
        
        path.remove(path.size() - 1);
    }
}