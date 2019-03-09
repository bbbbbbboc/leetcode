// 12. Integer to Roman

class Solution {
    public String intToRoman(int num) {
        if (num <= 0)
            return "";
        
        int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        int digit = 0;
        
        while (num > 0) {
            int times = num / nums[digit];
            num -= times * nums[digit];
            while (times > 0) {
                sb.append(symbols[digit]);
                times--;
            }
            digit++;
        }
        
        return sb.toString();
    }
}