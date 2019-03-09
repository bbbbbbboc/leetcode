// 698. Partition to K Equal Sum Subsets

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;
        
        for (int i : nums)
            sum += i;
        if (sum % k != 0)
            return false;
        
        int avg = sum / k;
        int row = nums.length - 1;
        
        if (nums[row] > avg)
            return false;
        
        while (row >= 0 && nums[row] == avg) {
            row--;
            k--;
        }
        
        return dfs(new int[k], row, nums, avg);
    }
    
    private boolean dfs(int[] groups, int row, int[] nums, int avg) {
        if (row < 0)
            return true;
        int v = nums[row--];
        for (int i = 0; i < groups.length; i++) {
            if (groups[i] + v <= avg) {
                groups[i] += v;
                if (dfs(groups, row, nums, avg))
                    return true;
                groups[i] -= v;
            }
            if (groups[i] == 0)
                break;
        }
        return false;
    }
}