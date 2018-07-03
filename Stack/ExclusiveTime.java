// 636. Exclusive Time of Functions

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        int prevTime = 0;
        
        for (String log : logs) {
            String[] parts = log.split(":");
            int id = Integer.valueOf(parts[0]);
            int currTime = Integer.valueOf(parts[2]);
            
            if (!stack.empty()) 
                ans[stack.peek()] += (currTime - prevTime);
            
            prevTime = currTime;
            
            if (parts[1].equals("start")) {
                stack.push(id);
            } else {
                ans[stack.pop()]++;
                prevTime++;
            }
        }
        
        return ans;
    }
}