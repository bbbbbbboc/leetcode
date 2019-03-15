class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        int n = matrix.size();
        int a = 0;
        int b = n - 1;
        while (a < b) {
            for (int i = 0; i < b - a; i++) {
                swap(matrix, a, a + i, a + i, b);
                swap(matrix, a, a + i, b, b - i);
                swap(matrix, a, a + i, b - i, a);
            }
            a++;
            b--;
        }
    }
    
    void swap(vector<vector<int>> &matrix, int i1, int j1, int i2, int j2) {
        int tmp = matrix[i1][j1];
        matrix[i1][j1] = matrix[i2][j2];
        matrix[i2][j2] = tmp;
    }
};