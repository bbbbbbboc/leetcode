// 152. Maximum Product Subarray

class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        
        int preMax = nums[0];
        int preMin = nums[0];
        int maxSoFar = nums[0];
        int currMax;
        int currMin;
        
        for (int i = 1; i < nums.length; i++) {
            currMax = Math.max(nums[i], Math.max(preMax * nums[i], preMin * nums[i]));
            currMin = Math.min(nums[i], Math.min(preMin * nums[i], preMax * nums[i]));
            
            maxSoFar = Math.max(maxSoFar, currMax);
            preMax = currMax;
            preMin = currMin;
        }
        
        return maxSoFar;
    }
}