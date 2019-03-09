// 417. Pacific Atlantic Water Flow

class Solution {
    class Coordinate {
        int x, y, val;
        Coordinate(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
    
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return ans;
        
        int n = matrix.length;
        int m = matrix[0].length;
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Queue<Coordinate> queue = new LinkedList<>();
                Set<Integer> visited = new HashSet<>();
                visited.add(i * m + j);
                Coordinate coor = new Coordinate(i, j, matrix[i][j]);
                queue.offer(coor);
                
                boolean Pacific = false;
                boolean Atlantic = false;
                
                if (i == 0 || j == 0)
                    Pacific = true;
                if (i == n - 1 || j == m - 1)
                    Atlantic = true;
                
                while (!queue.isEmpty()) {
                    Coordinate curr = queue.poll();
                    for (int k = 0; k < 4; k++) {
                        
                        int nx = curr.x + dx[k];
                        int ny = curr.y + dy[k];
                        
                        if (visited.contains(nx * m + ny))
                            continue;
                        
                        if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                            continue;
                        if (matrix[nx][ny] > curr.val) 
                            continue;    
                        
                        if (nx == 0 || ny == 0)
                            Pacific = true;
                        if (nx == n - 1 || ny == m - 1)
                            Atlantic = true;
                        queue.offer(new Coordinate(nx, ny, matrix[nx][ny]));
                        visited.add(nx * m + ny);
                    }
                    
                    if (Pacific && Atlantic)
                        break;
                }
                
                if (Pacific && Atlantic) {
                    int[] temp = new int[2];
                    temp[0] = i;
                    temp[1] = j;
                    ans.add(temp);
                }
            }
        }
        return ans;
    }
}