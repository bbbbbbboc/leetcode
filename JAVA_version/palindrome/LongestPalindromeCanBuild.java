//  409 Longest Palindrome    
public class LongestPalindromeCanBuild {
    public int longestPalindrom(String s) {
        if (s == null || s.isEmpty())
            return 0;
	
	int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        
        boolean hasOdd = false;
        
        for (char c : map.keySet()) {
            if (map.get(c) % 2 == 0) {
                ans += map.get(c);
            } else {
                ans += (map.get(c) - 1);
                hasOdd = true;
            }
        }
        
        return hasOdd ? ans + 1 : ans;
    }
}
