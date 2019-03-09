// 283. Move Zeroes

class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        
        int right = 0; // first 0
        int left = 0; // first non 0
        
        while (right < nums.length) {
            if (nums[right] != 0) {
                if (left != right) {
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                }
                left++;
            }
            right++;
        }
    }
}