// 415. Add Strings

class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i1 = num1.length() - 1;
        int i2 = num2.length() - 1;
        int carry = 0;
        
        while (i1 >= 0 || i2 >= 0 || carry != 0) {
            int curr = 0;
            
            if (i1 >= 0)
                curr += (num1.charAt(i1) - '0');
            if (i2 >= 0)
                curr += (num2.charAt(i2) - '0');
            
            curr += carry;
            carry = curr / 10;
            sb.append(curr % 10);
            
            i1--;
            i2--;
        }
        
        return sb.reverse().toString();
    }
}