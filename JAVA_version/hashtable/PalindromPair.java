// 336. Palindrome Pairs

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        if (words == null || words.length == 0)
            return ans;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                
                String str1 = words[i].substring(0, j);
                String str2 = words[i].substring(j);
                
                if (isPalindrome(str1)) {
                    String str2Rev = new StringBuilder(str2).reverse().toString();
                    if (map.containsKey(str2Rev) && map.get(str2Rev) != i) {
                        List<Integer> list = new ArrayList<>();
                        list.add(map.get(str2Rev));
                        list.add(i);
                        ans.add(list);
                    }
                }
                
                if (isPalindrome(str2)) {
                    String str1Rev = new StringBuilder(str1).reverse().toString();
                    if (map.containsKey(str1Rev) && map.get(str1Rev) != i && str2.length() != 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(map.get(str1Rev));
                        ans.add(list);
                    }
                }
            }
        }
        
        return ans;
    }
    
    private boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        
        while (l <= r) {
            if (s.charAt(l++) != s.charAt(r--))
                return false;
        }
        
        return true;
    }
}