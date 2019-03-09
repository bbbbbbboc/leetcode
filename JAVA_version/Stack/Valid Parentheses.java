// 20. Valid Parentheses
class Solution {
    public boolean isValid(String s) {
        if (s == null || s.isEmpty())
            return true;
        
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == '(' || curr == '[' || curr == '{') {
                stack.push(curr);
            } else if (curr == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (curr == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else if (curr == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else {
                return false;
            }
        }
        
        return stack.isEmpty();
    }
}