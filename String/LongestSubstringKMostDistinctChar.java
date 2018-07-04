// 340. Longest Substring with At Most K Distinct Characters

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int max = 0;
        if (s == null || s.length() == 0 || k <= 0)
            return 0;
        
        int start = 0;
        int end = 0;
        
        Map<Character, Integer> map = new HashMap<>();
        
        while (end < s.length()) {
            while (map.keySet().size() <= k && end < s.length()) {

                if (map.keySet().size() == k && end < s.length()) {
                    while (end < s.length() && map.containsKey(s.charAt(end))) {
                        map.put(s.charAt(end), map.get(s.charAt(end)) + 1);
                        end++;
                    }
                    break;
                }
                
                if (map.containsKey(s.charAt(end))) {
                    map.put(s.charAt(end), map.get(s.charAt(end)) + 1);
                } else {
                    map.put(s.charAt(end), 1);
                }
                end++;
            }

            map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
            
            if (map.get(s.charAt(start)) == 0)
                map.remove(s.charAt(start));
            start++;
            
            max = Math.max(max, end - start + 1);
        }
        
        return max;
    }
}