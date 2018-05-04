class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hash1 = new HashMap<>();
        HashMap<Integer, Integer> hash2 = new HashMap<>();
        
        for (int i : nums1) {
            if (hash1.containsKey(i)) {
                hash1.put(i, hash1.get(i) + 1);
            } else {
                hash1.put(i, 1);
            }
        }
        
        for (int i : nums2) {
            if (hash2.containsKey(i)) {
                hash2.put(i, hash2.get(i) + 1);
            } else {
                hash2.put(i, 1);
            }
        }
        
        List<Integer> list = new ArrayList<>();
        
        for (int i : hash1.keySet()) {
            if (hash2.containsKey(i)) {
                int count = Math.min(hash1.get(i), hash2.get(i));
                for (int j = 0; j < count; j++) {
                    list.add(i);
                }
            }
        }
        
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}