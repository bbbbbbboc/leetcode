// 711. Number of Distinct Islands II

class Solution {
    int n;
    int m;
    int lift;
    int[] dx = new int[]{0, 1, 0, -1};
    int[] dy = new int[]{1, 0, -1, 0};
    
    public int numDistinctIslands2(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
            return 0;
        
        n = grid.length;
        m = grid[0].length;
        lift = n + m;
        Set<String> shapes = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0)
                    continue;
                
                List<Integer> shape = new ArrayList<>();
                dfs(grid, i, j, shape);
                if (shape.size() > 0)
                    shapes.add(canonical(shape));
            }
        }
        return shapes.size();
    }
    
    private void dfs(int[][] grid, int i, int j, List<Integer> shape) {
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == 0)
            return;
        
        grid[i][j] = 0;
        shape.add(i * m + j);
        
        for (int k = 0; k < 4; k++) {
            dfs(grid, i + dx[k], j + dy[k], shape);
        }
    }
    
    public String canonical(List<Integer> shape) {
        String ans = "";
        int size = shape.size();
        int[] out = new int[size];
        int[] xs = new int[size];
        int[] ys = new int[size];

        for (int c = 0; c < 8; ++c) {
            int t = 0;
            for (int z: shape) {
                int x = z / m;
                int y = z % m;
                //x y, x -y, -x y, -x -y
                //y x, y -x, -y x, -y -x
                xs[t] = c <= 1 ? x : c <= 3 ? -x : c <= 5 ? y : -y;
                ys[t] = c <= 3 ? (c % 2 == 0 ? y : -y) : (c % 2 == 0 ? x : -x);
                t++;
            }

            int mx = xs[0], my = ys[0];
            for (int x: xs) mx = Math.min(mx, x);
            for (int y: ys) my = Math.min(my, y);

            for (int j = 0; j < shape.size(); ++j) {
                out[j] = (xs[j] - mx) * lift + (ys[j] - my);
            }
            
            Arrays.sort(out);
            String candidate = Arrays.toString(out);
            
            if (ans.compareTo(candidate) < 0) 
                ans = candidate;
        }
        return ans;
    }
}