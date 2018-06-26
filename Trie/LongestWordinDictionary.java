// 720. Longest Word in Dictionary

class Solution {

    class TrieNode {
        String word = "";
        TrieNode[] children = new TrieNode[26];

        void insert (String s) {
            char[] chs = s.toCharArray ();
            TrieNode curNode = this;
            for (int i = 0; i < chs.length; i++) {
                int index = chs[i] - 'a';
                if (curNode.children[index] == null)
                    curNode.children[index] = new TrieNode ();
                curNode = curNode.children[index];
            }
            curNode.word = s;
        }
    }
    
    public String longestWord(String[] words) {
        TrieNode root = new TrieNode();
        root.word = "-";
        for (String word : words) {
            root.insert(word);
        }
        return dfs(root, "");
    }
    
    private String dfs(TrieNode root, String accum) {
        if (root == null || root.word.length() == 0)
            return accum;
        String res = "";
        if (!root.word.equals("-")) 
            accum = root.word;
        
        for (TrieNode child : root.children) {
            String currRes = dfs(child, accum);
            if (currRes.length() > res.length() || (currRes.length() == res.length() && currRes.compareTo(res) < 0))
                res = currRes;
        }
        
        return res;
    }

}