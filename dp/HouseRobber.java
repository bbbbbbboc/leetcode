// 198. House Robber

class Solution {
    public int rob(int[] nums) {
        int preMax = 0;
        int currMax = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int oldMax = currMax;
            currMax = Math.max(currMax, preMax + nums[i]);
            preMax = oldMax;
        }
        
        return currMax;
    }
}