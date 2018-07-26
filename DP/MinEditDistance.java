// 72. Edit Distance

class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null)
            return -1;
        int len1 = word1.length();
        int len2 = word2.length();
        // f(i, j) := minimum cost (or steps) required to convert first i characters of word1 to first j characters of word2
        int[][] costs = new int[len1 + 1][len2 + 1];
        
        for (int i = 0; i <= len1; i++) {
            costs[i][0] = i;
        }
        for (int j = 0; j <= len2; j++) {
            costs[0][j] = j;
        }
        
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    costs[i + 1][j + 1] = costs[i][j];
                } else {
                    int replace = costs[i][j];
                    int insert = costs[i + 1][j];
                    int delete = costs[i][j + 1];
                    costs[i + 1][j + 1] = 1 + Math.min(replace, Math.min(delete, insert));
                }
            }
        }
        
        return costs[len1][len2];
    }
}