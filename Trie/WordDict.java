// 211. Add and Search Word - Data structure design

class WordDictionary {
    class TrieNode {
        TrieNode[] children;
        String item;
        
        TrieNode() {
            children = new TrieNode[26];
            item = "";
        }
    }

    TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null)
                curr.children[c - 'a'] = new TrieNode();
            curr = curr.children[c - 'a'];
        }
        curr.item = word;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }
    
    private boolean match(char[] arr, int i, TrieNode curr) {
        if (i == arr.length)
            return !curr.item.equals("");
        
        if (arr[i] != '.')
            return curr.children[arr[i] - 'a'] != null && match(arr, i + 1, curr.children[arr[i] - 'a']);
        
        for (int j = 0; j < 26; j++) {
            if (curr.children[j] != null) {
                if (match(arr, i + 1, curr.children[j]))
                    return true;
            }
        }
        
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */