/*
241. Different Ways to Add Parentheses
time: O(n) - O(n^2)
*/

class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ans = new ArrayList<>();
        if (input == null || input.length() == 0)
            return ans;
        
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> p1 = diffWaysToCompute(input.substring(0, i));
                List<Integer> p2 = diffWaysToCompute(input.substring(i + 1));
                
                int val = 0;
                for (int k : p1) {
                    for (int j : p2) {
                        switch (c) {
                            case '+':
                                val = k + j;
                                break;
                            case '-':
                                val = k - j;
                                break;
                            case '*':
                                val = k * j;
                                break;
                        }
                        ans.add(val);
                    }
                }
            }
        }
        
        if (ans.size() == 0) {
            ans.add(Integer.valueOf(input));
        }
        
        return ans;
    }
}