// 78. Subsets

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        helper(nums, results, 0, new ArrayList<>());
        return results;
    }
    
    private void helper(int[] nums, List<List<Integer>> results, int startIndex, List<Integer> currSubset) {
        results.add(new ArrayList<>(currSubset));
        
        for (int i = startIndex; i < nums.length; i++) {
            currSubset.add(nums[i]);
            helper(nums, results, i + 1, currSubset);
            currSubset.remove(currSubset.size() - 1);
        }
    }
}