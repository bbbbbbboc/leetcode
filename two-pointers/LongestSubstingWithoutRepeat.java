// 3. Longest Substring Without Repeating Characters

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        if (s.length() == 1)
            return 1;

        int maxLen = 1;
        int left = 0;
        int right = 1;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(left));

        while (left < s.length()) {
            while (right < s.length()) {
                if (set.contains(s.charAt(right))) {
                    break;
                }
                set.add(s.charAt(right));
                right++;
            }

            maxLen = Math.max(maxLen, right - left);
            set.remove(s.charAt(left));
            left++;
        }

        return maxLen;
    }
}