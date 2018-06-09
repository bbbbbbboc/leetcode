// 451. Sort Characters By Frequency

class Solution {

    public String frequencySort(String s) {
        if (s == null || s.length() == 0)
            return "";

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }

        Queue<Character> pq = new PriorityQueue<>(new Comparator<Character>() {
           public int compare(Character c1, Character c2) {
               return - (map.get(c1) - map.get(c2));
           }
        });

        for (char c : map.keySet()) {
            pq.offer(c);
        }

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            char c = pq.poll();
            for (int i = 0; i < map.get(c); i++) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
