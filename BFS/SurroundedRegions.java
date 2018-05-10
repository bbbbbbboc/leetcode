// 130. Surrounded Regions

class Solution {
    int n, m;
    int[] dx = new int[]{0, 1, 0, -1};
    int[] dy = new int[]{1, 0, -1, 0};
    
    class UnionFind {
        int[] father;
        
        UnionFind(int n) {
            father = new int[n];
            for (int i = 0; i < n; i++) {
                father[i] = i;
            }
        }
        
        int findRoot(int n) {
            if (father[n] == n)
                return n;
            return father[n] = findRoot(father[n]);
        }
        
        void connect(int a, int b) {
            int rootA = father[a];
            int rootB = father[b];
            father[rootA] = rootB;
        }
    }
    
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0)
            return;
        
        n = board.length;
        m = board[0].length;
        UnionFind uf = new UnionFind(n * m);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'X') 
                    continue;
                
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 'O') {
                        uf.connect(convertToId(i, j), convertToId(nx, ny));
                    }
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'X') 
                    continue;
                
                int root = uf.findRoot(convertToId(i, j));
                int rootX = root / m;
                int rootY = root % m;
                
                if (rootX > 0 && rootX < n - 1 && rootY > 0 && rootY < m - 1) {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    private int convertToId(int i, int j) {
        return i * m + j;
    }
}


// V2 BFS
class Solution {
    int[] dx = new int[]{0, 1, 0, -1};
    int[] dy = new int[]{1, 0, -1, 0};
    int n, m;
    
    class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0)
            return;
        
        n = board.length;
        m = board[0].length;
        Queue<Point> queue = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                queue.offer(new Point(i, 0));
            }
            if (board[i][m - 1] == 'O') {
                queue.offer(new Point(i, m - 1));
            }
        }
        
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O') {
                queue.offer(new Point(0, j));
            }
            if (board[n - 1][j] == 'O') {
                queue.offer(new Point(n - 1, j));
            }
        }
        
        while (!queue.isEmpty()) {
            Point curr = queue.poll();
            board[curr.x][curr.y] = 'W';
            for (int k = 0; k < 4; k++) {
                int nx = curr.x + dx[k];
                int ny = curr.y + dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 'O')
                    queue.offer(new Point(nx, ny));
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'W') {
                    System.out.println("jjj");
                    board[i][j] = 'O';
                }       
            }
        }
    }
    
}