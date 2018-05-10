// 111. Minimum Depth of Binary Tree

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
    public int minDepth(TreeNode root) {
        int depth = 0;
        if (root == null)
            return 0;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left == null && curr.right == null) {
                    return depth;
                } 
                
                if (curr.left != null)
                    queue.offer(curr.left);
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
        }
        
        return depth;
    }
}



// V2 DFS Recursion
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        
        if (root.left == null || root.right == null)
            return left + right + 1;
        else
            return Math.min(left, right) + 1;
    }
}