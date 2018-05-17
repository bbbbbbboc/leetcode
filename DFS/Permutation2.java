// 47. Permutations II

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return results;
        
        Arrays.sort(nums);
        helper(nums, results, new ArrayList<>(), new HashSet<>());
        return results;
    }
    
    private void helper(int[] nums, List<List<Integer>> results, List<Integer> curr, Set<Integer> visitedIndexes) {
        if (curr.size() == nums.length) {
            results.add(new ArrayList<>(curr));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (visitedIndexes.contains(i))
                continue;
            if (i > 0 && !visitedIndexes.contains(i - 1) && nums[i] == nums[i - 1])
                continue;
            
            curr.add(nums[i]);
            visitedIndexes.add(i);
            helper(nums, results, curr, visitedIndexes);
            curr.remove(curr.size() - 1);
            visitedIndexes.remove(i);
        }
    }
}