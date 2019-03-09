// 329. Longest Increasing Path in a Matrix

class Solution {
    int[] dx = new int[]{0, 1, 0, -1};
    int[] dy = new int[]{1, 0, -1, 0};
    int n;
    int m;
    
    public int longestIncreasingPath(int[][] matrix) {
        int maxLen = 0;
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return 0;
        n = matrix.length;
        m = matrix[0].length;
        int[][] cache = new int[n][m];
                
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int currLen = getLongestPath(matrix, i, j, cache);
                maxLen = Math.max(maxLen, currLen);
            }
        }
        
        return maxLen;
    }
    
    private int getLongestPath(int[][] matrix, int x, int y, int[][] cache) {
        if (cache[x][y] != 0)
            return cache[x][y];
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && matrix[nx][ny] > matrix[x][y]) {
                cache[x][y] = Math.max(cache[x][y], getLongestPath(matrix, nx, ny, cache));
            }
        }
        
        cache[x][y]++;
        return cache[x][y];
    }
}