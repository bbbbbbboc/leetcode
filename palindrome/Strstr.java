public class Strstr {
	public int strstr(String haystack, String needle) {
		if (haystack == null || needle == null)
			return -1;

		for (int i = 0; i <= haystack.length() - needle.length(); i++) {
			int len = 0;

			for (int j = 0; j < needle.length(); j++) {
				if (haystack.charAt(i + j) != needle.charAt(j))
					break;
				else
					len++;
			}

			if (len == needle.length())
				return i;
		}

		return -1;
	}
}