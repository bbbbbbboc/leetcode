// 367. Valid Perfect Square

class Solution {
    public boolean isPerfectSquare(int num) {
        if (num <= 1)
            return true;

        int left = 1;
        int right = num / 2;

        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if ((long) mid * (long) mid < (long) num)
                left = mid;
            else
                right = mid;
        }

        if (left * left == num || right * right == num)
            return true;
        return false;
    }
}
