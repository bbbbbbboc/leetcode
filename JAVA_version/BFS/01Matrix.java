// 542. 01 Matrix

class Solution {
    class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int[][] updateMatrix(int[][] matrix) {
        
        int n = matrix.length;
        int m = matrix[0].length;
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        
        int[][] ans = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    ans[i][j] = 0;
                    continue;
                }
                
                Point p = new Point(i, j);
                Queue<Point> queue = new LinkedList<>();
                queue.offer(p);
                int dis = 0;
                boolean find = false;
                
                while (!queue.isEmpty()) {
                    dis++;
                    int size = queue.size();
                    for (int k = 0; k < size; k++) {
                        Point curr = queue.poll();
                        for (int a = 0; a < 4; a++) {
                            int nx = curr.x + dx[a];
                            int ny = curr.y + dy[a];
                            if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                                continue;
                            if (matrix[nx][ny] == 1) {
                                queue.offer(new Point(nx, ny));
                            } else {
                                find = true;
                                break;
                            }
                        }
                        if (find)
                            break;
                    }
                    if (find)
                        break;
                }
                
                ans[i][j] = dis;
            }
        }
        
        return ans;
    }
}