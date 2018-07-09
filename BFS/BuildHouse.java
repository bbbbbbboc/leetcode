// 317. Shortest Distance from All Buildings

class Solution {
    public int shortestDistance(int[][] grid) {
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int minDis = Integer.MAX_VALUE;
        int n = grid.length;
        int m = grid[0].length;
        
        int houseCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1)
                    houseCount++;
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 || grid[i][j] == 2)
                    continue;
                
                int dis = 0;
                int totalDis = 0;
                Queue<Integer> queue = new LinkedList<>();
                Set<Integer> visited = new HashSet<>();
                int count = 0;
                queue.offer(convertToId(i, j, m));
                visited.add(convertToId(i, j, m));
                
                while (!queue.isEmpty()) {
                    int size = queue.size();
                    for (int k = 0; k < size; k++) {
                        int curr = queue.poll();
                        int currX = curr / m;
                        int currY = curr % m;
                        if (grid[currX][currY] == 1) {
                            count++;
                            totalDis += dis;
                        } else if (grid[currX][currY] == 2) {
                            continue;
                        } else {
                            for (int q = 0; q < 4; q++) {
                                int nx = currX + dx[q];
                                int ny = currY + dy[q];
                                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited.contains(convertToId(nx, ny, m))) {
                                    queue.offer(convertToId(nx, ny, m));
                                    visited.add(convertToId(nx, ny, m));
                                }
                            }
                        }
                    }
                    dis++;
                }
                
                if (count == houseCount)
                    minDis = Math.min(minDis, totalDis);
            }
        }
        
        return minDis == Integer.MAX_VALUE ? -1 : minDis;
    }
    
    private int convertToId(int x, int y, int m) {
        return x * m + y;
    }
}