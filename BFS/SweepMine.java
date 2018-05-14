// 529. Minesweeper

class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int n = board.length;
        int m = board[0].length;
        // int[] dx = new int[]{0, 1, 0, -1};
        // int[] dy = new int[]{1, 0, -1, 0};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(click);
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            
            if (board[x][y] == 'M') {
                board[x][y] = 'X';
                break;
            }
            
            int count = 0;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i == 0 && j == 0)
                        continue;
                    int nx = x + i;
                    int ny = y + j;
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                        continue;
                    if (board[nx][ny] == 'X' || board[nx][ny] == 'M')
                        count++;
                }
            }
            
            if (count > 0) {
                board[x][y] = (char) ('0' + count);
                continue;
            }
            
            board[x][y] = 'B';
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i == 0 && j == 0)
                        continue;
                    int nx = x + i;
                    int ny = y + j;
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                        continue;
                    if (board[nx][ny] == 'E') {
                        queue.offer(new int[]{nx, ny});
                        board[nx][ny] = 'B';
                    }
                }
            }
        }
        
        return board;
    }
}