// 361. Bomb Enemy

class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
            return 0;
        
        int max = 0;
        int n = grid.length;
        int m = grid[0].length;
        int row = 0;
        int[] col = new int[m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'W')
                    continue;
                if (i == 0 || grid[i - 1][j] == 'W')
                    col[j] = calcColKill(grid, i, j, n, m);
                if (j == 0 || grid[i][j - 1] == 'W')
                    row = calcRowKill(grid, i, j, n, m);
                if (grid[i][j] == '0')
                    max = Math.max(max, row + col[j]);
            }
        }
        
        return max;
    }
    
    private int calcColKill(char[][] grid, int i, int j, int n, int m) {
        int count = 0;
        while (i < n && grid[i][j] != 'W') {
            if (grid[i][j] == 'E')
                count++;
            i++;
        }
        return count;
    }
    
    private int calcRowKill(char[][] grid, int i, int j, int n, int m) {
        int count = 0;
        while (j < m && grid[i][j] != 'W') {
            if (grid[i][j] == 'E')
                count++;
            j++;
        }
        return count;
    }
}