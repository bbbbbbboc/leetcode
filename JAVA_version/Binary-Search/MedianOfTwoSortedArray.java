// 4. Median of Two Sorted Arrays
// O(n)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null)
            return -1;
        
        List<Integer> merged = mergeTwoArrays(nums1, nums2);
        int len = merged.size();

        if (len % 2 == 0) {
        	return ((double) merged.get(len / 2 - 1) + (double) merged.get(len / 2)) / 2;
        } else {
        	return (double) merged.get(len / 2);
        }
    }

    private List<Integer> mergeTwoArrays(int[] nums1, int[] nums2) {
    	List<Integer> ans = new ArrayList<>();
    	int idx1 = 0;
    	int idx2 = 0;

    	while (idx1 < nums1.length && idx2 < nums2.length) {
    		if (nums1[idx1] < nums2[idx2]) {
    			ans.add(nums1[idx1]);
    			idx1++;
    		} else {
    			ans.add(nums2[idx2]);
    			idx2++;
    		}
    	}

    	while (idx1 < nums1.length) {
    		ans.add(nums1[idx1]);
    		idx1++;
    	}
    	while (idx2 < nums2.length) {
    		ans.add(nums2[idx2]);
    		idx2++;
    	}

    	return ans;
    }
}