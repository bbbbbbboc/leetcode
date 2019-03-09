// 71. Simplify Path

class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0)
            return "";
        
        String[] parts = path.split("/");
        
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].equals("") || parts[i].equals(".")) {
                continue;
            } else if (parts[i].equals("..")) {
                if (!stack.empty())
                    stack.pop();
            } else {
                stack.push("/" + parts[i]);
            }
        }
        
        String res = "";
        while (!stack.empty()) {
            res = stack.pop() + res;
        }
        
        if (res.equals(""))
            res = "/";
        
        return res;
    }
}