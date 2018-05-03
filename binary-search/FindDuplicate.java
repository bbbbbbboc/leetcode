// 287. Find the Duplicate Number

class Solution {
    public int findDuplicate(int[] nums) {
        // write your code here
        int left = 1;
        int right = nums.length - 1;
        
        while (left < right - 1) {
            int mid = (left + right) / 2;
            if (checkValid(nums, mid) <= mid)
                left = mid;
            else
                right = mid;
        }
        
        if (checkValid(nums, left) <= left)
            return right;
        return left;
    }
    
    private int checkValid(int[] nums, int mid) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= mid)
                count++;
        }
        return count;
    }
}