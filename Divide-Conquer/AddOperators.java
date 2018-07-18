// 282. Expression Add Operators

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        dfs(num, target, "", 0, 0, 0, ans);
        return ans;
    }
    
    private void dfs(String num, int target, String path, int start, long eval, long multed, List<String> ans) {
        if (start == num.length()) {
            if (target == eval)
                ans.add(path);
            return;
        }
        
        for (int i = start; i < num.length(); i++) {
            if (i != start && num.charAt(start) == '0')
                break;
            
            long curr = Long.parseLong(num.substring(start, i + 1));
            if (start == 0) {
                dfs(num, target, path + curr, i + 1, curr, curr, ans);
                continue;
            }
            
            dfs(num, target, path + "+" + curr, i + 1, eval + curr, curr, ans);
            dfs(num, target, path + "-" + curr, i + 1, eval - curr, -curr, ans);
            dfs(num, target, path + "*" + curr, i + 1, eval - multed + multed * curr, multed * curr, ans);
        }
    }
}