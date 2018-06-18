// 449. Serialize and Deserialize BST

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    // use preorder traversal
    public String serialize(TreeNode root) {
        if (root == null)
            return null;
        
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.empty()) {
            TreeNode curr = stack.pop();
            sb.append(curr.val + ",");
            if (curr.right != null)
                stack.push(curr.right);
            if (curr.left != null)
                stack.push(curr.left);
        }
        
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null)
            return null;
        
        String[] parts = data.split(",");
        Queue<Integer> queue = new LinkedList<>();
        for (String part : parts) {
            queue.offer(Integer.parseInt(part));
        }
        return helper(queue);
    }
    
    private TreeNode helper(Queue<Integer> queue) {
        if (queue.isEmpty())
            return null;
        
        TreeNode root = new TreeNode(queue.poll());
        Queue<Integer> smallerQueue = new LinkedList<>();
        
        while (!queue.isEmpty() && queue.peek() < root.val) {
            smallerQueue.offer(queue.poll());
        }
        
        root.left = helper(smallerQueue);
        root.right = helper(queue);
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));