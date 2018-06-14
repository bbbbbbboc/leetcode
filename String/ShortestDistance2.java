// 244. Shortest Word Distance II

class WordDistance {
    Map<String, List<Integer>> map;
    
    public WordDistance(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) {
                map.put(words[i], new ArrayList<>());
            }
            map.get(words[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int minDis = Integer.MAX_VALUE;
        
        for (int i = 0, j = 0; i < l1.size() && j < l2.size(); ) {
            int idx1 = l1.get(i);
            int idx2 = l2.get(j);
            if (idx1 < idx2) {
                minDis = Math.min(minDis, idx2 - idx1);
                i++;
            } else {
                minDis = Math.min(minDis, idx1 - idx2);
                j++;
            }
        }   

        return minDis;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */