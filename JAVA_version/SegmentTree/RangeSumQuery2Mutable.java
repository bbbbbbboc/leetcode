// 308. Range Sum Query 2D - Mutable

class NumMatrix {
    // We use colSums[i][j] = the sum of ( matrix[0][j], matrix[1][j], matrix[2][j],......,matrix[i - 1][j] ).
    int[][] colSums;
    int[][] matrix;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return;
        
        int n = matrix.length;
        int m = matrix[0].length;
        colSums = new int[n + 1][m];
        this.matrix = matrix;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                colSums[i][j] = colSums[i - 1][j] + matrix[i - 1][j];
            }
        }
    }
    
    public void update(int row, int col, int val) {
        int oldVal = matrix[row][col];
        for (int i = row + 1; i < colSums.length; i++) {
            colSums[i][col] = colSums[i][col] + val - oldVal;
        }
        matrix[row][col] = val;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        for (int j = col1; j <= col2; j++) {
            res += (colSums[row2 + 1][j] - colSums[row1][j]);
        }
        return res;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */