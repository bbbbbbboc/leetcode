// 443. String Compression

class Solution {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0)
            return 0;
        
        int anchor = 0;
        int write = 0;
        
        for (int read = 0; read < chars.length; read++) {
            if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
                chars[write++] = chars[anchor];
                if (read > anchor) {
                    char[] arr = ("" + (read - anchor + 1)).toCharArray();
                    for (int i = 0; i < arr.length; i++) {
                        chars[write++] = arr[i];
                    }
                }
                anchor = read + 1;
            }
        }
        
        return write;
    }
}