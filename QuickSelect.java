class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return -1;
        return quickSelect(nums, 0, nums.length - 1, k);
    }
    
    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end)
            return nums[start];
        
        int left = start;
        int right = end;
        int pivot = nums[(left + right) / 2];
        
        // j will be on the left, i will be on the right
        while (left <= right) {
            while (left <= right && nums[left] > pivot) {
                left++;
            }
            while (left <= right && nums[right] < pivot) {
                right--;
            }
            
            if (left <= right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            }
        }
        
        // on the left of j
        if (start + k - 1 <= right) 
            return quickSelect(nums, start, right, k);
        // on the right of i
        if (start + k - 1 >= left)
            return quickSelect(nums, left, end, k - (left - start));
        // there is a number between j and i
        return nums[right + 1];
    }
}