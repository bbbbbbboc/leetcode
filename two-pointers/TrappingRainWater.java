// 42. Trapping Rain Water

class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0)
            return 0;

        int left = 0;
        int right = height.length - 1;
        int leftHeight = height[left];
        int rightHeight = height[right];
        int rain = 0;

        while (left < right) {
            if (leftHeight < rightHeight) {
                left++;
                if (leftHeight < height[left]) {
                    leftHeight = height[left];
                } else {
                    rain += (leftHeight - height[left]);
                }
            } else {
                right--;
                if (rightHeight < height[right]) {
                    rightHeight = height[right];
                } else {
                    rain += (rightHeight - height[right]);
                }
            }
        }
        
        return rain; 
    }
}