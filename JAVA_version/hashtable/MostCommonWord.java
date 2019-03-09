// 819. Most Common Word

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bans = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        
        for (String s : banned) {
            bans.add(s);
        }
        
        String res = "";
        int max = 0;
        
        String[] parts = paragraph.split(" ");
        for (String word : parts) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                if (!isPunctuation(c))
                    sb.append(c);
            }
            String s = sb.toString().toLowerCase();
            if (bans.contains(s))
                continue;
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
            
            if (map.get(s) > max) {
                max = map.get(s);
                res = s;
            }
        }
        
        return res;
    }
    
    private boolean isPunctuation(char c) {
        int cc = (int) c;
        if (cc == 33 || cc == 39 || cc == 63 || cc == 44 || cc == 46 || cc == 59)
            return true;
        return false;
    }
}