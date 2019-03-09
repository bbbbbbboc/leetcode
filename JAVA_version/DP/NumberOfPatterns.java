// 351. Android Unlock Patterns

class Solution {
    public int numberOfPatterns(int m, int n) {
        int count = 0;
        for (int len = m; len <= n; len++) {
            boolean[] used = new boolean[9];
            count += calcPatterns(-1, len, used);
        }
        return count;
    }
    
    private int calcPatterns(int last, int len, boolean[] used) {
        if (len == 0)
            return 1;
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            if (isValid(i, last, used)) {
                used[i] = true;
                sum += calcPatterns(i, len - 1, used);
                used[i] = false;
            }
        }
        
        return sum;
    }
    
    private boolean isValid(int index, int last, boolean[] used) {
        if (used[index])
            return false;
        // first digit of the pattern    
        if (last == -1)
            return true;
        // knight moves or adjacent cells (in a row or in a column)        
        if ((index + last) % 2 == 1)
            return true;
        // indexes are at both end of the diagonals for example 0,0, and 8,8          
        int mid = (index + last)/2;
        if (mid == 4)
            return used[mid];
        // adjacent cells on diagonal  - for example 0,0 and 1,0 or 2,0 and //1,1
        if ((index%3 != last%3) && (index/3 != last/3)) {
            return true;
        }
        // all other cells which are not adjacent
        return used[mid];
    }
}