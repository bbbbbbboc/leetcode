// 314. Binary Tree Vertical Order Traversal

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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> columns = new LinkedList<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        columns.offer(0);
        int min = 0;
        int max = 0;
        
        while (!nodes.isEmpty()) {
            TreeNode currNode = nodes.poll();
            int currCol = columns.poll();
            
            if (!map.containsKey(currCol))
                map.put(currCol, new ArrayList<>());
            map.get(currCol).add(currNode.val);
            
            if (currNode.left != null) {
                nodes.offer(currNode.left);
                columns.offer(currCol - 1);
                min = Math.min(min, currCol - 1);
            }
            
            if (currNode.right != null) {
                nodes.offer(currNode.right);
                columns.offer(currCol + 1);
                max = Math.max(max, currCol + 1);
            }
        }
        
        for (int i = min; i <= max; i++) {
            ans.add(map.get(i));
        }
        return ans;
    }
}