public class MinimumInRotatedArray {

	public static findMin(int[] arr) {
		if (arr == null || arr.length == 0)
			return 0;
		int left = 0;
		int right = arr.length - 1;

		while (left < right - 1) {
			int mid = (left + right) / 2;
			if (nums[mid] > nums[right])
				left = mid;
			else
				right = mid;
		}
		return Math.min(nums[left], nums[right]);
	}
}