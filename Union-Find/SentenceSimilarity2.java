// 737. Sentence Similarity II

class Solution {
    int id = 1;
    
    class UnionFind {
        int[] fathers;
        
        UnionFind(int n) {
            fathers = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                fathers[i] = i;
            }
        }
        
        int findRoot(int x) {
            if (fathers[x] == x)
                return x;
            return fathers[x] = findRoot(fathers[x]);
        }
        
        void connect(int x, int y) {
            int fatherX = findRoot(x);
            int fatherY = findRoot(y);
            if (fatherX == fatherY)
                return;
            
            fathers[fatherX] = fatherY;
        }
    }
    
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        
        if (words1 == null || words2 == null || words1.length != words2.length)
            return false;
        
        Map<String, Integer> map = new HashMap<>();
        for (String[] pair : pairs) {
            addWord(pair[0], map);
            addWord(pair[1], map);
        }
        
        for (String word : words1) {
            addWord(word, map);
        }
        
        for (String word : words2) {
            addWord(word, map);
        }
        
        UnionFind uf = new UnionFind(id);
        for (String[] pair : pairs) {
            uf.connect(map.get(pair[0]), map.get(pair[1]));
        }
        
        for (int i = 0; i < words1.length; i++) {
            if (words1[i].equals(words2[i]))
                continue;
            
            if (uf.findRoot(map.get(words1[i])) != uf.findRoot(map.get(words2[i])))
                return false;
        }
        
        return true;
    }
    
    private void addWord(String word, Map<String, Integer> map) {
        if (!map.containsKey(word)) {
            map.put(word, id);
            id++;
        }
    }
}