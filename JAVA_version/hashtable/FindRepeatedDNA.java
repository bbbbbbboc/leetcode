// 187. Repeated DNA Sequences

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() <= 10)
            return new ArrayList<>();

        Set<String> set = new HashSet<>();
        Set<String> resSet = new HashSet<>();

        for (int i = 0; i <= s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);
            if (set.contains(sub))
                resSet.add(sub);
            else
                set.add(sub);
        }

        return new ArrayList<>(resSet);
    }
}
