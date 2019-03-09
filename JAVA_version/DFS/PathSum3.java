// 437. Path Sum III

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
    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        return helper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);

    }
    
    private int helper(TreeNode root, int sum) {
        if (root == null)
            return 0;
        return (root.val == sum ? 1 : 0) + helper(root.left, sum - root.val) + helper(root.right, sum - root.val);
    }
}





// hashmap + prefix sum
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
    int count = 0;
    
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        helper(root, map, 0, sum);
        return count;
    }
    
    private void helper(TreeNode root, Map<Integer, Integer> map, int currSum, int target) {
        if (root == null)
            return;
        
        currSum += root.val;
        
        if (map.containsKey(currSum - target))
            count += map.get(currSum - target);
        
        if (map.containsKey(currSum)) {
            map.put(currSum, map.get(currSum) + 1);
        } else {
            map.put(currSum, 1);
        }
        
        helper(root.left, map, currSum, target);
        helper(root.right, map, currSum, target);
        map.put(currSum, map.get(currSum) - 1);
    }
}