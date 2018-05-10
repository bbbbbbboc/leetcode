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
                grid[i][j] = '0';
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



class Solution {
    int[] dx = new int[]{0, 1, 0, -1};
    int[] dy = new int[]{1, 0, -1, 0};
    
    class UnionFind {
        int count;
        int[] father;
        
        UnionFind(int n) {
            father = new int[n];
            for (int i = 0; i < n; i++) {
                father[i] = i;
            }
        }
        
        void connect(int a, int b) {
            int rootA = findRoot(a);
            int rootB = findRoot(b);
            if (rootA != rootB) {
                father[rootA] = rootB;
                count--;
            }
        }
        
        int findRoot(int n) {
            if (father[n] == n)
                return n;
            return father[n] = findRoot(father[n]);
        }
        
        void setCount(int count) {
            this.count = count;
        }
        
        int query() {
            return count;
        }
    }
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
            return 0;
        
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;
        UnionFind uf = new UnionFind(n * m);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1')
                    count++;
            }
        }
        
        uf.setCount(count);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '0')
                    continue;
                
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == '1')
                        uf.connect(i * m + j, nx * m + ny);
                }
                
            }
        }
        
        return uf.query();
    }
}