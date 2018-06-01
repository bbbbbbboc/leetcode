// 66. Plus One

class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0)
            return digits;
        
        boolean carry = false;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == digits.length - 1) {
                int curr = digits[i] + 1;
                if (curr > 9) {
                    carry = true;
                    digits[i] = 0;
                } else {
                    digits[i] += 1;
                    return digits;
                }
            } else {
                if (carry) {
                    int curr = digits[i] + 1;
                    if (curr == 10) {
                        digits[i] = 0;
                    } else {
                        digits[i] += 1;
                        return digits;
                    }
                } else {
                    return digits;
                }
            }
        }
        
        int[] newDigits =  new int[digits.length + 1];
        newDigits[0] = 1;
        for (int i = 0; i < digits.length; i++) {
            newDigits[i + 1] = digits[i];
        }
        
        return newDigits;
    }
}