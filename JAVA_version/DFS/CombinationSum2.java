// 40. Combination Sum II

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        
        if (candidates == null || candidates.length == 0)
            return ans;
        
        Arrays.sort(candidates);
        boolean[] visited = new boolean[candidates.length];
        
        helper(candidates, target, 0, ans, new ArrayList<>(), visited);
        return ans;
    }
    
    private void helper(int[] candidates, int target, int start, List<List<Integer>> ans, List<Integer> curr, boolean[] visited) {
        if (target < 0)
            return;
        
        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1] && !visited[i - 1])
                continue;
            
            curr.add(candidates[i]);
            visited[i] = true;
            helper(candidates, target - candidates[i], i + 1, ans, curr, visited);
            visited[i] = false;
            curr.remove(curr.size() - 1);
        }
    }
}