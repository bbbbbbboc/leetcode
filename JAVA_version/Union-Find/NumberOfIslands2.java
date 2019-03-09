// 305. Number of Islands II

class Solution {
    int[] dx = new int[]{0, 1, 0, -1};
    int[] dy = new int[]{1, 0, -1, 0};
    
    class UnionFind {
        int[] fathers;
        int count;
        
        UnionFind(int n) {
            count = 0;
            fathers = new int[n];
            for (int i = 0; i < n; i++) {
                fathers[i] = i;
            }
        }
        
        void connect(int a, int b) {
            int rootA = findRoot(a);
            int rootB = findRoot(b);
            if (rootA != rootB) {
                fathers[rootA] = rootB;
                count--;
            }
        }
        
        int findRoot(int a) {
            if (fathers[a] == a)
                return a;
            return fathers[a] = findRoot(fathers[a]);
        }
        
        void incrementCount() {
            count++;
        }
        
        int getCount() {
            return count;
        }
    }
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        UnionFind uf = new UnionFind(m * n);
        int[][] grid = new int[m][n];
        
        for (int[] pos : positions) {
            int id = pos[0] * n + pos[1];
            uf.incrementCount();
            grid[pos[0]][pos[1]] = 1;
            for (int i = 0; i < 4; i++) {
                int nx = pos[0] + dx[i];
                int ny = pos[1] + dy[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1)
                    uf.connect(id, nx * n + ny);
            }
            ans.add(uf.getCount());
        }
        
        return ans;
    }
}