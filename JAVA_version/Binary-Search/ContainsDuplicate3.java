// 220. Contains Duplicate III

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2 || k < 1)
            return false;
        
        TreeSet<Long> set = new TreeSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            long l = (long) nums[i];
            Long floor = set.floor(l); // get the greatest in set smaller than l
            Long ceil = set.ceiling(l); // get the smallest in set greater than l
            
            if (floor != null && l - floor <= t || ceil != null && ceil - l <= t)
                return true;
            
            set.add(l);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        
        return false;
    }
}