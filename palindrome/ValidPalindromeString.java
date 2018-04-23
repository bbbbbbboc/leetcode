public class ValidPalindromeString {
	private boolean checkValid(char c) {
		return Character.isLetter(c) || Character.isDigit(c);
	}

	public boolean isPalindrome(String s) {
		if (s == null || s.isEmpty())
			return true;
		int left = 0;
		int right = s.length() - 1;

		while (left < right) {
			while (left < s.length() && !checkValid(s.charAt(left)))
				left++;

			if (left == s.length())
				return true;

			while (right >= 0 && !checkValid(s.charAt(right)))
				right--;

			if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
				return false;

			left++;
			right--;
		}

		return true;
	}
}