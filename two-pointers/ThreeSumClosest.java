// 16. 3Sum Closest

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3)
            return 0;
        
        int ans = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        
        for (int i = 0; i <= nums.length - 3; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                
                if (sum > target) {
                    right--;
                } else {
                    left++;
                }
                if (Math.abs(ans - target) > Math.abs(sum - target)) {
                    ans = sum;
                }
            }
        }
        return ans;
    }
}