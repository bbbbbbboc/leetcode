// 85. Maximal Rectangle

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return 0;
        
        int maxArea = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[] heights = new int[m];
        
        for (int i = 0; i < n; i++) {
            updateHeights(heights, matrix, i);
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        
        return maxArea;
    }
    
    private void updateHeights(int[] heights, char[][] matrix, int level) {
        for (int i = 0; i < matrix[level].length; i++) {
            if (level == 0) {
                heights[i] = matrix[0][i] == '1' ? 1 : 0;
            } else {
                heights[i] = matrix[level][i] == '1' ? 1 + heights[i] : 0;
            }
        }
    }
    
    private int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;
        
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])
                max = Math.max(max, heights[stack.pop()] * (i - stack.peek() - 1));
            stack.push(i);
        }
        
        while (stack.peek() != -1) {
            max = Math.max(max, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        
        return max;
    }
}