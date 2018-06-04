// 224. Basic Calculator

class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0)
            return 0;
        
        int res = 0;
        int num = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                continue;
            } else if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + (int) (s.charAt(i) - '0');
            } else if (s.charAt(i) == '+') {
                res += sign * num;
                sign = 1;
                num = 0;
            } else if (s.charAt(i) == '-') {
                res += sign * num;
                sign = -1;
                num = 0;
            } else if (s.charAt(i) == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                res += sign * num;
                num = 0;
                res *= stack.pop();     // sign outside the para
                res += stack.pop();     // stuff before the para
            }
        }
        
        if (num != 0)
            res += sign * num;
        
        return res;
    }
}