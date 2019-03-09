// 212. Word Search II

class Solution {
    class TrieNode {
        String word;
        TrieNode[] next;
        
        TrieNode() {
            next = new TrieNode[26];
        }
    }
    
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        
        for (String word : words) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (curr.next[i] == null) {
                    curr.next[i] = new TrieNode();
                }
                curr = curr.next[i];
            }
            curr.word = word;
        }
        return root;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        if (board == null || board.length == 0)
            return ans;
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, ans);
            }
        }
        
        return ans;
    }
    
    private void dfs(char[][] board, int i, int j, TrieNode n, List<String> ans) {
        char c = board[i][j];
        if (c == '#' || n.next[c - 'a'] == null)
            return;
        n = n.next[c - 'a'];
        if (n.word != null) {
            ans.add(n.word);
            n.word = null;
        }
        
        board[i][j] = '#';
        
        if (i > 0)
            dfs(board, i - 1, j, n, ans);
        if (j > 0)
            dfs(board, i, j - 1, n, ans);
        if (i < board.length - 1)
            dfs(board, i + 1, j, n, ans);
        if (j < board[0].length - 1)
            dfs(board, i, j + 1, n, ans);
        
        board[i][j] = c;
    }
}