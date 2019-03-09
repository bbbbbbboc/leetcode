// 80. Remove Duplicates from Sorted Array II

class Solution {
    public int removeDuplicates(int[] nums) {
        int len = 0;
        if (nums == null || nums.length == 0)
            return len;
        
        int slow = 1;
        int fast = 1;
        int count = 1;
        
        while (fast < nums.length) {
            if (nums[fast] != nums[fast - 1]) {
                count = 1;
                nums[slow] = nums[fast];
                slow++;
            } else {
                if (count < 2) {
                    nums[slow] = nums[fast];
                    slow++;
                    count++;
                }
            }
            fast++;
        }
        
        return slow;
    }
}