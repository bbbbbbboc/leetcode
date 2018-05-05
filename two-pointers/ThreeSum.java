// 15. 3Sum

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3)
            return ans;
        
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            twoSum(nums, i + 1, nums.length - 1, -nums[i], ans);        
        }
        return ans;
    }
    
    private void twoSum(int[] nums, int left, int right, int target, List<List<Integer>> res) {
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                left++;
            } else if (nums[left] + nums[right] > target) {
                right--;
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(-target);
                temp.add(nums[left]);
                temp.add(nums[right]);
                res.add(temp);
                left++;
                right--;
                
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
                while (right > left && nums[right] == nums[right + 1]) {
                    right--;
                }
            }
        }
    }
}