/* 
229. Majority Element II
find all ele appears more than n/3 times
use hashtable
time: O(n) space: O(n)
*/

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();
        
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
            
            if (map.get(i) > n / 3) {
                set.add(i);
            }
        }
        
        return new ArrayList<>(set);
    }
}