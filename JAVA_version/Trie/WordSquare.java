// 425. Word Squares

class Solution {
    class TrieNode {
        List<String> startsWith;
        TrieNode[] children;
        
        TrieNode() {
            startsWith = new ArrayList<>();
            children = new TrieNode[26];
        }
    }
    
    class Trie {
        TrieNode root;
        
        Trie(String[] words) {
            root = new TrieNode();
            for (String word : words) {
                TrieNode curr = root;
                for (char ch : word.toCharArray()) {
                    int idx = ch - 'a';
                    if (curr.children[idx] == null) 
                        curr.children[idx] = new TrieNode();
                    curr.children[idx].startsWith.add(word);
                    curr = curr.children[idx];
                }
            }
        }
        
        List<String> findByPrefix(String prefix) {
            List<String> res = new ArrayList<>();
            TrieNode curr = root;
            for (char ch : prefix.toCharArray()) {
                int idx = ch - 'a';
                if (curr.children[idx] == null)
                    return res;
                curr = curr.children[idx];
            }
            res.addAll(curr.startsWith);
            return res;
        }
    }
    
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> ans = new ArrayList<>();
        if (words == null || words.length == 0)
            return ans;
        Trie trie = new Trie(words);
        List<String> curr = new ArrayList<>();
        for (String w : words) {
            curr.add(w);
            search(words[0].length(), trie, ans, curr);
            curr.remove(curr.size() - 1);
        }
        return ans;
    }
    
    private void search(int len, Trie trie, List<List<String>> ans, List<String> curr) {
        if (curr.size() == len) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        
        int idx = curr.size();
        StringBuilder sb = new StringBuilder();
        for (String s : curr) {
            sb.append(s.charAt(idx));
        }
        
        List<String> startsWith = trie.findByPrefix(sb.toString());
        for (String sw : startsWith) {
            curr.add(sw);
            search(len, trie, ans, curr);
            curr.remove(curr.size() - 1);
        }
    }
}