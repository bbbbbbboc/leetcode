// 95. Unique Binary Search Trees II
// generate all paths

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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList<>();
        
        return helper(1, n);
    }
    
    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> ans = new ArrayList<>();
        if (start > end) {
            ans.add(null);
            return ans;
        }
        
        if (start == end) {
            ans.add(new TreeNode(start));
            return ans;
        }
        
        List<TreeNode> left;
        List<TreeNode> right;
        
        for (int i = start; i <= end; i++) {
            left = helper(start, i - 1);
            right = helper(i + 1, end);
            
            for (TreeNode ln : left) {
                for (TreeNode rn : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = ln;
                    root.right = rn;
                    ans.add(root);
                }
            }
        } 
        return ans;
    }
}