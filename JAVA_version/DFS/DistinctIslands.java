// 694. Number of Distinct Islands

class Solution {
    int[] dx = new int[]{0, 1, 0, -1};
    int[] dy = new int[]{1, 0, -1, 0};
    char[] dir = new char[]{'u', 'r', 'd', 'l'};
    
    public int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
            return 0;
        
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0)
                    continue;
                StringBuilder path = new StringBuilder();
                dfs(grid, i, j, path, 'o');
                set.add(path.toString());
            }
        }
        return set.size();
    }
    
    private void dfs(int[][] grid, int i, int j, StringBuilder path, char direction) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0)
            return;
        
        grid[i][j] = 0;
        path.append(direction);
        
        for (int k = 0; k < 4; k++) {
            dfs(grid, i + dx[k], j + dy[k], path, dir[k]);
        }
        
        path.append('b');
    }
}