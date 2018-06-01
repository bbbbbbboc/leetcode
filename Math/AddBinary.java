// 67. Add Binary

class Solution {
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0)
            return b;
        if (b == null || b.length() == 0)
            return a;
        
        int idxA = a.length() - 1;
        int idxB = b.length() - 1;
        String res = "";
        boolean carry = false;
        
        while (idxA >= 0 || idxB >= 0 || carry) {
            int curr = 0;
            if (idxA >= 0)
                curr += (a.charAt(idxA) - '0');
            if (idxB >= 0)
                curr += (b.charAt(idxB) - '0');
            if (carry)
                curr += 1;
            carry = false;
            
            if (curr > 1) {
                carry = true;
                curr = curr % 2;
            }
            
            res = curr + res;
            idxA--;
            idxB--;
        }
        
        return res;
    }
}