// 388. Longest Absolute File Path

class Solution {
    public int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<>();
        String[] parts = input.split("\n");
        stack.push(0);
        int maxLen = 0;
        
        for (String s : parts) {
            // number of \t
            int level = s.lastIndexOf("\t") + 1;
            
            // find parent
            while (level + 1 < stack.size()) {
                stack.pop();
            }
            
            int len = stack.peek() + s.length() - level + 1;
            stack.push(len);
            
            if (s.contains("."))
                maxLen = Math.max(maxLen, len - 1);
        }
        
        return maxLen;
    }
}