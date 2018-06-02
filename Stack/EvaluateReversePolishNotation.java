// 150. Evaluate Reverse Polish Notation

class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0)
            return 0;
        
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < tokens.length; i++) {
            String curr = tokens[i];
            if (!curr.equals("+") && !curr.equals("-") && !curr.equals("*") && !curr.equals("/")) {
                stack.push(Integer.valueOf(curr));
            } else {
                int v1 = stack.pop();
                int v2 = stack.pop();
                int compute = 0;
                
                if (curr.equals("+"))
                    compute = v1 + v2;
                if (curr.equals("-"))
                    compute = v2 - v1;
                if (curr.equals("*"))
                    compute = v1 * v2;
                if (curr.equals("/"))
                    compute = v2 / v1;
                
                stack.push(compute);
            }
        }
        
        return stack.pop();
    }
}