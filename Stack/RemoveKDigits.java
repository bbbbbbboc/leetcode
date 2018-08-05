// 402. Remove K Digits

class Solution {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        if (len == k)
            return "0";
        
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (k > 0 && !stack.empty() && num.charAt(i) < stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        
        // corner case like 11111111
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        sb.reverse();

        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        
        return sb.toString();
    }
}