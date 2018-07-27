// 228. Summary Ranges

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return ans;
        
        int idx = 0;
        
        while (idx < nums.length) {
            int start = nums[idx];
            int end = nums[idx];
            
            idx++;
            
            while (idx < nums.length && nums[idx] == nums[idx - 1] + 1) {
                end = nums[idx];
                idx++;
            }
            
            if (start == end) {
                ans.add(start + "");
            } else {
                ans.add(start + "->" + end);
            }
        }
        
        return ans;
    }
}