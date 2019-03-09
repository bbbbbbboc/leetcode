// 257. Binary Tree Paths

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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root == null)
            return ans;
        
        dfs(root, ans, "");
        return ans;
    }
    
    private void dfs(TreeNode curr, List<String> ans, String path) {

        path += curr.val;
        
        if (curr.left == null && curr.right == null) {
            ans.add(path);
            return;
        }
        
        if (curr.left != null) {
            dfs(curr.left, ans, path + "->");
        } 
        if (curr.right != null) {
            dfs(curr.right, ans, path + "->");
        }
    }
}