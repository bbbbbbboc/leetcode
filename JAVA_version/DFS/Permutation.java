// 46. Permutations

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return results;
        
        helper(nums, results, new ArrayList<Integer>());
        return results;
    }
    
    private void helper(int[] nums, List<List<Integer>> results, List<Integer> curr) {
        if (curr.size() == nums.length) {
            results.add(new ArrayList<>(curr));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (curr.contains(nums[i]))
                continue;
            
            curr.add(nums[i]);
            helper(nums, results, curr);
            curr.remove(curr.size() - 1);
        }
    }
}