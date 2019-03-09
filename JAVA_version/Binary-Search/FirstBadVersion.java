// 278. First Bad Version

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid))
                right = mid;
            else
                left = mid;
        }
        
        return isBadVersion(left) ? left : right;
    }
}