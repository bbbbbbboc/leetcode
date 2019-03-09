// 34. Search for a Range

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        if (nums == null || nums.length == 0)
            return ans;

        int first = findElement(nums, target, true);
        int last = findElement(nums, target, false);
        ans[0] = first;
        ans[1] = last;
        return ans;
    }
    
    private int findElement(int[] nums, int target, boolean first) {
        if (nums == null || nums.length == 0)
            return -1;

        int left = 0;
        int right = nums.length - 1;

        while (left < right - 1) {
            int mid = left + (right - left) / 2;

            if (first) {
                if (nums[mid] < target)
                    left = mid;
                else
                    right = mid;
            } else {
                if (nums[mid] <= target)
                    left = mid;
                else
                    right = mid;
            }
        } 

        if (first) {
            if (nums[left] == target)
                return left;
            if (nums[right] == target)
                return right;
        } else {
            if (nums[right] == target)
                return right;
            if (nums[left] == target)
                return left;
        }
        
        return -1;
    }
}