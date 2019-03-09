// 271. Encode and Decode Strings

public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append("/").append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> ans = new ArrayList<>();
        int idx = 0;
        
        while (idx < s.length()) {
            int slash = s.indexOf('/', idx);
            int size = Integer.valueOf(s.substring(idx, slash));
            ans.add(s.substring(slash + 1, slash + size + 1));
            idx = slash + size + 1;
        }
        return ans;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));