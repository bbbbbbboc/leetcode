// 324. Wiggle Sort II

class Solution {
    public void wiggleSort(int[] nums) {
        int median = findKthLargest(nums, (nums.length + 1) / 2);
        int n = nums.length;

        int left = 0, i = 0, right = n - 1;

        while (i <= right) {

            if (nums[newIndex(i,n)] > median) {
                swap(nums, newIndex(left++,n), newIndex(i++,n));
            }
            else if (nums[newIndex(i,n)] < median) {
                swap(nums, newIndex(right--,n), newIndex(i,n));
            }
            else {
                i++;
            }
        }
          
    }

    private int newIndex(int index, int n) {
        return (1 + 2*index) % (n | 1);
    }
    
    private int findKthLargest(int[] nums, int k) {
        return nums[quickSelect(nums, 0, nums.length - 1, nums.length - k + 1)];
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
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
        int count = i - low + 1;
        
        if (count == k)
            return i;
        else if (count > k) 
            return quickSelect(nums, low, i - 1, k);
        else
            return quickSelect(nums, i + 1, high, k - count);
    }
}