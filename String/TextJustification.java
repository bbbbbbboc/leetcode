// 68. Text Justification

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        if (words == null || words.length == 0)
            return ans;
        
        int idx = 0;
        while (idx < words.length) {
            
            int count = words[idx].length();
            int last = idx + 1;
            while (last < words.length) {
                if (words[last].length() + count + 1 > maxWidth) break;
                count += words[last].length() + 1;
                last++;
            }
            
            
            StringBuilder sb = new StringBuilder();
            int diff = last - idx - 1;
            
            if (last == words.length || diff == 0) {
                for (int i = idx; i < last; i++) {
                    sb.append(words[i] + " ");
                }
                sb.deleteCharAt(sb.length() - 1);
                for (int i = sb.length(); i < maxWidth; i++) {
                    sb.append(" ");
                }
            } else {
                int spaces = (maxWidth - count) / diff;
                int r = (maxWidth - count) % diff;
                for (int i = idx; i < last; i++) {
                    sb.append(words[i]);
                    if (i < last - 1) {
                        for (int j = 0; j <= (spaces + ((i - idx) < r ? 1 : 0)); j++) {
                            sb.append(" ");
                        }
                    }
                }
            }

            ans.add(sb.toString());
            idx = last;
        }
        
        return ans;
    }
}