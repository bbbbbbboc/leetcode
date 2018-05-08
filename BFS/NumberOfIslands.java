// 200. Number of Islands

class Solution {
    class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid.length == 0)
            return 0;
        
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                
                if (grid[i][j] == '0') {
                    continue;
                }
                
                Queue<Point> queue = new LinkedList<>();
                queue.offer(new Point(i, j));
                grid[i][j] = 0;
                count++;
                
                while (!queue.isEmpty()) {
                    Point curr = queue.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = curr.x + dx[k];
                        int ny = curr.y + dy[k];
                        
                        if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == '1') {
                            queue.offer(new Point(nx, ny));
                            grid[nx][ny] = '0';
                        }
                    }
                }
            }
        }
        
        return count;
    }
}