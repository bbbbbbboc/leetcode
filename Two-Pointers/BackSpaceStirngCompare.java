// 844. Backspace String Compare

class Solution {
    public boolean backspaceCompare(String S, String T) {
        if (S == null || T == null)
            return false;
        
        int skipS = 0;
        int skipT = 0;
        int idxS = S.length() - 1;
        int idxT = T.length() - 1;
        
        while (idxS >= 0 || idxT >= 0) {
            while (idxS >= 0) {
                if (S.charAt(idxS) == '#') {
                    skipS++;
                    idxS--;
                } else if (skipS > 0) {
                    skipS--;
                    idxS--;
                } else {
                    break;
                }
            }
            
            while (idxT >= 0) {
                if (T.charAt(idxT) == '#') {
                    skipT++;
                    idxT--;
                } else if (skipT > 0) {
                    skipT--;
                    idxT--;
                } else {
                    break;
                }
            }
            
            if (idxS >= 0 && idxT >= 0 && S.charAt(idxS) != T.charAt(idxT))
                return false;
            
            if (idxS >= 0 != idxT >= 0)
                return false;
            
            idxS--;
            idxT--;
        }
        
        return true;
    }
}