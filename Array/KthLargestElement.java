// 215. Kth Largest Element in an Array

class Solution {
    public int findKthLargest(int[] nums, int k) {
        return nums[quickSelect(nums, 0, nums.length - 1, nums.length - k + 1)];
    }
    
    private int quickSelect(int[] nums, int low, int high, int k) {
        int i = low;
        int j = high;
        int pivot = nums[high];
        
        while (i < j) {
            if (nums[i++] > pivot) {
                i--;
                j--;
                swap(nums, i, j);
            }
        }
        
        swap(nums, i, high);
        // count the number of elements <= pivot
        int count = i - low + 1;
        
        if (count == k) {
            return i;
        } else if (count > k) {
            return quickSelect(nums, low, i - 1, k);
        } else {
            return quickSelect(nums, i + 1, high, k - count);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}