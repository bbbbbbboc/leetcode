// 349. Intersection of Two Arrays

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> intersect = new HashSet<>();

        for (int i : nums1) {
            set.add(i);
        }

        for (int i : nums2) {
            if (set.contains(i))
                intersect.add(i);
        }

        int[] ans = new int[intersect.size()];
        int idx = 0;

        for (int i : intersect)
            ans[idx++] = i;
        return ans;
    }
}