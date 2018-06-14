// 245. Shortest Word Distance III

class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        if (word1.equals(word2)) {
            int idx = 0;
            int idx1 = -1;
            int idx2 = -1;
            int minDis = Integer.MAX_VALUE;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(word1)) {
                    if (list.size() > 0) {
                        minDis = Math.min(minDis, i - list.get(list.size() - 1));
                    }
                    list.add(i);
                }
            }
            return minDis;
            
        } else {
            int idx1 = -1;
            int idx2 = -1;
            int minDis = Integer.MAX_VALUE;
            
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(word1)) {
                    idx1 = i;
                }
                if (words[i].equals(word2)) {
                    idx2 = i;
                }
                if (idx1 != -1 && idx2 != -1) {
                    minDis = Math.min(Math.abs(idx1 - idx2), minDis);
                }
            }
            return minDis;
        }
    }
}