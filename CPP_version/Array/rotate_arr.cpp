/* 3 step rotating
1. [0, size - k)
2. [size - k, size)
3. [0, size)
*/
class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        int size = nums.size();
        if (size == 0 || k <= 0)
            return;
        
        k = k % size;
        reverse(nums, 0, size - k - 1);
        reverse(nums, size - k, size - 1);
        reverse(nums, 0, size - 1);
    }
    
private:
    void reverse(vector<int> &nums, int start, int end) {
         while (start < end) {
             int tmp = nums[start];
             nums[start] = nums[end];
             nums[end] = tmp;
             start++;
             end--;
         }
    }
};