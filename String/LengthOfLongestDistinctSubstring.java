// 159. Longest Substring with At Most Two Distinct Characters

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0)
            return 0;
        
        int start = 0;
        int end = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        
        while (end < s.length()) {
            while (end < s.length()) {
                if (map.keySet().size() == 2 && !map.containsKey((int) s.charAt(end)))
                    break;
                if (!map.containsKey((int) s.charAt(end)))
                    map.put((int) s.charAt(end), 0);
                map.put((int) s.charAt(end), map.get((int) s.charAt(end)) + 1);
                end++;
            }
            
            maxLen = Math.max(maxLen, end - start);
            
            map.put((int) s.charAt(start), map.get((int) s.charAt(start)) - 1);
            if (map.get((int) s.charAt(start)) == 0)
                map.remove((int) s.charAt(start));
            start++;
        }
        
        return maxLen;
    }
}