// 79. Word Search

class Solution {
    boolean[][] visited;
    int n;
    int m;
    
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0)
            return false;
        
        n = board.length;
        m = board[0].length;
        visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0) && search(board, i, j, word, 0))
                    return true;
            }
        }
        
        return false;
    }
    
    private boolean search(char[][] board, int i, int j, String word, int idx) {
        if (idx == word.length())
            return true;
        
        if (i >= n || i < 0 || j >= m || j < 0 || board[i][j] != word.charAt(idx) || visited[i][j])
            return false;
        
        visited[i][j] = true;
        
        if (search(board, i-1, j, word, idx+1) || search(board, i+1, j, word, idx+1) || search(board, i, j-1, word, idx+1) || search(board, i, j+1, word, idx+1)){
            return true;
        }
        
        visited[i][j] = false;
        return false;
    }
}