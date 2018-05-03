// 162. Find Peak Element

class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        
        int start = 0;
        int end = nums.length - 1;
        
        while (start <= end) {
            if (start == end - 1) {
                return nums[start] > nums[end] ? start : end;
            }
            
            if (start == end)
                return start;
            
            int mid = (start + end) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
                return mid;
            else if (nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1])
                start = mid + 1;
            else
                end = mid - 1;
        }
        
        return -1;
    }
}