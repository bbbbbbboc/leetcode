// 270. Closest Binary Search Tree Value

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
    public int closestValue(TreeNode root, double target) {
        int currVal = root.val;
        TreeNode kid = currVal < target ? root.right : root.left;
        if (kid == null)
            return currVal;
        int kidVal = closestValue(kid, target);
        return Math.abs(currVal - target) < Math.abs(kidVal - target) ? currVal : kidVal;
    }
}