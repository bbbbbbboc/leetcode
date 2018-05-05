// 283. Move Zeroes

class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0)
            return;

        int insertPos = 0;;
        for (int i : nums) {
            if (i == 0)
                continue;
            nums[insertPos++] = i;
        }

        for (int i = insertPos + 1; i < nums.length; i++) {
            nums[i] = 0;
        }
    }           
}