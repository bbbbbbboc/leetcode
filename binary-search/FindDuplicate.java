// 287. Find the Duplicate Number

class Solution {
    public int findDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            for (int i : nums) {
                if (i <= mid)
                    count++;
            }

            if (count <= mid)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return left;
    }
}