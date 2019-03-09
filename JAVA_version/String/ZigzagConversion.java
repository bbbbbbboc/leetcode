// 6. ZigZag Conversion

class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows <= 1)
            return s;
        
        int len = s.length();
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }
        
        int idxRow = 0;
        int idxS = 0;
        boolean down = true;
        
        while (idxS < len) {
            sbs[idxRow].append(s.charAt(idxS));
            if (down) 
                idxRow++;
            else 
                idxRow--;
            
            if (idxRow == numRows - 1 || idxRow == 0) 
                down = !down;

            idxS++;
        }
        
        String res = "";
        for (int i = 0; i < numRows; i++) {
            res += sbs[i].toString();
        }
        
        return res;
    }
}