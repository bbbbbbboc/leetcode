// 11. Container With Most Water

class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0)
            return 0;

        int left = 0;
        int right = height.length;
        int ans = 0;

        while (left < right) {
            ans = Math.max(ans, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right])
                left++;
            else
                right--;
        }

        return ans;
    }
}