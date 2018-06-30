class Solution {
    public List<String> removeComments(String[] source) {
        List<String> ans = new ArrayList<>();
        boolean inBlock = false;
        StringBuilder newLine = new StringBuilder();
        
        for (String line : source) {
            char[] arr = line.toCharArray();
            int len = line.length();
            int idx = 0;
            if (!inBlock) 
                newLine = new StringBuilder();
            
            while (idx < line.length()) {
                if (!inBlock && idx + 1 < len && arr[idx] == '/' && arr[idx + 1] == '*') {
                    inBlock = true;
                    idx++;
                } else if (inBlock && idx + 1 < len && arr[idx] == '*' && arr[idx + 1] == '/') {
                    inBlock = false;
                    idx++;
                } else if (!inBlock && idx + 1 < len && arr[idx] == '/' && arr[idx + 1] == '/') {
                    break;
                } else if (!inBlock) {
                    newLine.append(arr[idx]);
                }
                idx++;
            }
            
            if (!inBlock && newLine.length() > 0)
                ans.add(newLine.toString());
        }
        
        return ans;
    }
}