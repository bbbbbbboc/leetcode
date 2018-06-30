// 683. K Empty Slots
// sliding window, both time and space O(n)


class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        
        // index is position of flower, val is day that it blooms
        int[] days = new int[flowers.length];
        for (int i = 0; i < flowers.length; i++) {
            days[flowers[i] - 1]= i + 1;
        }
        
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int right = k + 1;
        
        search: while (right < days.length) {
            for (int i = left + 1; i < right; i++) {
                if (days[i] < days[left] || days[i] < days[right]) {
                    left = i;
                    right = i + k + 1;
                    continue search;
                }
            }
            ans = Math.min(ans, Math.max(days[left], days[right]));
            left = right;
            right = left + k + 1;
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}