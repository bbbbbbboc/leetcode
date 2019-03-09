// 689. Maximum Sum of 3 Non-Overlapping Subarrays

class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] w = new int[nums.length - k + 1];
        int sum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i >= k)
                sum -= nums[i - k];
            if (i >= k - 1) 
                w[i - k + 1] = sum;
        }
        
        int[] left = new int[w.length];
        int best = 0;
        for (int i = 0; i < w.length; i++) {
            best = w[i] > w[best] ? i : best;
            left[i] = best;
        }
        
        int[] right = new int[w.length];
        best = w.length - 1;
        for (int i = w.length - 1; i >= 0; i--) {
            best = w[i] > w[best] ? i : best;
            right[i] = best;
        }
        
        int[] ans = new int[]{-1, -1, -1};
        for (int i = k; i < w.length - k; i++) {
            int j = left[i - k];
            int l = right[i + k];
            if (ans[0] == -1 || w[j] + w[i] + w[l] > w[ans[0]] + w[ans[1]] + w[ans[2]]) {
                ans[0] = j;
                ans[1] = i;
                ans[2] = l;
            }
        }
        
        return ans;
    }
}