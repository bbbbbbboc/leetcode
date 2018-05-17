// 658. Find K Closest Elements

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> results = new ArrayList<>();
        if (arr == null || arr.length == 0)
            return results;
        
        int left = 0;
        int right = arr.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > x) {
                right = mid;
            } else {
                left = mid;
            }
        }
        
        int closestIdx = Math.abs(arr[left] - x) < Math.abs(arr[right] - x) ? left : right;
        int l = closestIdx - 1;
        int r = closestIdx + 1;
        int count = 1;
        results.add(arr[closestIdx]);
        while (count < k) {
            if (l < 0) {
                results.add(arr[r]);
                r++;
            } else if (r >= arr.length) {
                results.add(0, arr[l]);
                l--;
            } else {
                if (Math.abs(arr[l] - x) <= Math.abs(arr[r] - x)) {
                    results.add(0, arr[l]);
                    l--;
                } else {
                    results.add(arr[r]);
                    r++;
                }
            }
            count++;
        }
        
        return results;
    }
}