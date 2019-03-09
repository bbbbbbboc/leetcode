// 863. All Nodes Distance K in Binary Tree

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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> ans = new ArrayList<>();
        if (root == null || target == null || K < 0)
            return ans;
        
        Map<TreeNode, TreeNode> fathers = new HashMap<>();
        Set<TreeNode> visited = new HashSet<>();
        traverse(root, fathers);
        
        if (root != target && !fathers.containsKey(target))
            return ans;
        
        finder(target, K, visited, ans, fathers);
        return ans;
    }
    
    private void traverse(TreeNode curr, Map<TreeNode, TreeNode> fathers) {
        if (curr == null)
            return;
        if (curr.left != null)
            fathers.put(curr.left, curr);
        if (curr.right != null)
            fathers.put(curr.right, curr);
        traverse(curr.left, fathers);
        traverse(curr.right, fathers);
    }
    
    private void finder(TreeNode curr, int dis, Set<TreeNode> visited, List<Integer> ans, Map<TreeNode, TreeNode> fathers) {
        if (dis == 0) {
            ans.add(curr.val);
            return;
        }
        
        visited.add(curr);
        if (curr.left != null && !visited.contains(curr.left))
            finder(curr.left, dis - 1, visited, ans, fathers);
        if (curr.right != null && !visited.contains(curr.right))
            finder(curr.right, dis - 1, visited, ans, fathers);
        if (fathers.containsKey(curr) && !visited.contains(fathers.get(curr)))
            finder(fathers.get(curr), dis - 1, visited, ans, fathers);
    }
}