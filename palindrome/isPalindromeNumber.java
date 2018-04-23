public class isPalindromeNumber {
	public boolean isPalindrome(int x) {
		String s = Stirng.valueOf(x);
		int i = 0;

		while (i < s.length() / 2) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i))
				break;
			else
				i++;
		}

		if (i == s.length() / 2)
			return true;
		else
			return false;
	}

	public boolean approach2(int x) {
		if (x < 0 || (x % 10 == 0 && x != 0))
			return false;

		int invert = 0;
		while (invert < x) {
			invert = invert * 10 + x % 10;
			x /= 10;
		}

		return x == invert || x == invert / 10;
	}
}