// 69. Sqrt(x)

class Solution {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if ((long) mid * (long) mid > x) 
                right = mid;
            else
                left = mid;
        }

        if ((long) right * (long) right < x)
            return right;
        return left;
    }
}