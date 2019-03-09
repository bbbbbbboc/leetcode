// 240. Search a 2D Matrix II

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return false;

        int col = matrix[0].length - 1;
        int row = 0;

        while (row < matrix.length && col >= 0) {
            if (target < matrix[row][col])
                col--;
            else if (target > matrix[row][col])
                row++;
            else
                return true;
        }

        return false;
    }
}