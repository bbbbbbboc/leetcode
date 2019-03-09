// 633. Sum of Square Numbers

class Solution {
    public boolean judgeSquareSum(int c) {
        if (c < 0)
            return false;
        int left = 0;
        int right = (int) Math.sqrt(c);

        while (left <= right) {
            int curr = left * left + right * right;
            if (curr < c)
                left++;
            else if (curr > c)
                right--;
            else
                return true;
        }
        return false;
    }
}
