// 153. Find Minimum in Rotated Sorted Array

public class MinimumInRotatedArray {

	// Version1
	public int findMin(int[] arr) {
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

	// Version2
	public int findMin(int[] arr) {
		if (arr == null || arr.length == 0)
			return 0;
		int left = 0;
		int right = arr.length - 1;

		while (left < right) {
			int mid = (left + right) / 2;
			if (mid > 0 && arr[mid] < arr[mid - 1])
				return arr[mid];

			if (arr[mid] >= arr[left] && arr[mid] > arr[right])
				left = mid + 1;
			else
				right = mid - 1;
		}
		return arr[left];
	}
}