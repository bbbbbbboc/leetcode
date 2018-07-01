// 215. Kth Largest Element in an Array

class Solution {
    public int findKthLargest(int[] nums, int k) {
        return nums[quickSelect(nums, 0, nums.length - 1, nums.length - k + 1)];
    }
    
    private int quickSelect(int[] nums, int start, int end, int k) {
        int left = start;
        int right = end;
        int pivot = nums[(start + end) / 2];
        
        while (left <= right) {
            while (left <= right && nums[left] > pivot)
                left++;
            while (left <= right && nums[right] < pivot)
                right--;
                
            if (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        } 
        
        if (start + k - 1 <= right)
            return quickSelect(nums, start, right, k);
        if (start + k - 1 >= left)
            return quickSelect(nums, left, end, k - (left - start));
            
        return nums[right + 1];
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}