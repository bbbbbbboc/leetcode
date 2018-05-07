// 75. Sort Colors

class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2)
            return;
        
        int left = 0;
        int right = nums.length - 1;
        int idx = 0;
        
        while (idx <= right) {
            if (nums[idx] == 1) {
                idx++;
            } else if (nums[idx] == 0) {
                swap(nums, left, idx);
                left++;
                idx++;
            } else {
                swap(nums, right, idx);
                right--;
            }
        }
    }
    
    private void swap(int[] nums, int p1, int p2) {
        int temp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = temp;
    }
}