// 103. Binary Tree Zigzag Level Order Traversal

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean reverse = false;
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();
                currLevel.add(curr.val);
                
                if (curr.left != null) {
                    queue.offer(curr.left);
                } 
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            
            if (reverse) {
                Collections.reverse(currLevel);
            }
            ans.add(currLevel);
            reverse = !reverse;
        }
        
        return ans;
    }
}