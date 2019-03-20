class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        int usedRow[9][9] = {0};
        int usedCol[9][9] = {0};
        int usedSq[9][9] = {0};
        
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board[i].size(); j++) {
                if (board[i][j] == '.')
                    continue;
                
                int val = board[i][j] - '1';
                int k = i / 3 * 3 + j / 3;
                if (usedRow[i][val] || usedCol[j][val] || usedSq[k][val])
                    return false;
                usedRow[i][val] = 1;
                usedCol[j][val] = 1;
                usedSq[k][val] = 1;
            }
        }
        
        return true;
    }
};