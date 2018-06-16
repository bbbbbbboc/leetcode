// 682. Baseball Game

class Solution {
    public int calPoints(String[] ops) {
        int sum = 0;
        if (ops == null || ops.length == 0)
            return sum;
        
        Stack<Integer> stack = new Stack<>();
        
        for (String s : ops) {
            try {
                int i = Integer.parseInt(s);
                stack.push(i);
                sum += i;
            } catch (NumberFormatException e) {
                if (s.equals("+")) {
                    int temp = stack.pop();
                    int currSum = temp + stack.peek();
                    sum += currSum;
                    stack.push(temp);
                    stack.push(currSum);
                    
                } else if (s.equals("C")) {
                    int i = stack.pop();
                    sum -= i;
                } else if (s.equals("D")) {
                    int i = stack.peek();
                    i = i * 2;
                    sum += i;
                    stack.push(i);
                }
            }
        }
        
        return sum;
    }
    
}