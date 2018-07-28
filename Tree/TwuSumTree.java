// 653. Two Sum IV - Input is a BST

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
    public boolean findTarget(TreeNode root, int k) {
        if (root == null)
            return false;
        Set<Integer> visited = new HashSet<>();
        return traverse(root, visited, k);
    }
    
    private boolean traverse(TreeNode root, Set<Integer> visited, int k) {
        if (root == null)
            return false;
        if (visited.contains(k - root.val))
            return true;
        visited.add(root.val);
        return traverse(root.left, visited, k) || traverse(root.right, visited, k);
    }
}