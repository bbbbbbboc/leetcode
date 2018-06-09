// 205. Isomorphic Strings

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0)
            return true;

        int[] alphabate = new int[256];
        for (int i = 0; i < 256; i++)
            alphabate[i] = -1;
        int len = s.length();
        Set<Integer> used = new HashSet<>();

        for (int i = 0; i < len; i++) {
            if (alphabate[(int) s.charAt(i)] != -1) {
                if ((int) t.charAt(i) != alphabate[(int) s.charAt(i)])
                    return false;
            } else {
                System.out.println(1);
                if (used.contains((int) t.charAt(i)))
                    return false;
                alphabate[(int) s.charAt(i)] = (int) t.charAt(i);
                used.add((int) t.charAt(i));
            }
        }

        return true;
    }
}
