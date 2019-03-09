// 695. Max Area of Island

class Solution {
    class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
            return 0;
        
        int maxArea = 0;
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0)
                    continue;
                
                int area = 0;
                Queue<Point> queue = new LinkedList<>();
                queue.offer(new Point(i, j));
                grid[i][j] = 0;
                
                while (!queue.isEmpty()) {
                    Point curr = queue.poll();
                    area++;
                    System.out.println("x:" + curr.x + ",y:" + curr.y);
                    
                    for (int k = 0; k < 4; k++) {
                        int nx = curr.x + dx[k];
                        int ny = curr.y + dy[k];
                        if (nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length)
                            continue;
                        
                        if (grid[nx][ny] == 1) {
                            queue.offer(new Point(nx, ny));
                            grid[nx][ny] = 0;
                        }
                    }
                }
                
                maxArea = Math.max(maxArea, area);
            }
        }
        
        return maxArea;
    }
}






// DFS version
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
            return 0;
        
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        
        for (int i = 0; i <n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0)
                    continue;
                ans = Math.max(ans, dfs(grid, i, j, n, m, 0));
            }
        }
        
        return ans;
    }
    
    private int dfs(int[][] grid, int i, int j, int n, int m, int area) {
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == 0)
            return area;
        
        grid[i][j] = 0;
        area++;
        
        area = dfs(grid, i + 1, j, n, m, area);
        area = dfs(grid, i, j + 1, n, m, area);
        area = dfs(grid, i - 1, j, n, m, area);
        area = dfs(grid, i, j - 1, n, m, area);
        
        return area;
    }
}