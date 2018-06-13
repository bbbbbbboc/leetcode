// 269. Alien Dictionary

class Solution {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0)
            return "";
        
        Map<Character, Integer> degrees = new HashMap<>();
        Map<Character, Set<Character>> edges = new HashMap<>();
        
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (degrees.containsKey(c))
                    continue;
                degrees.put(c, 0);
            }
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            String prev = words[i];
            String curr = words[i + 1];
            int len = Math.min(prev.length(), curr.length());
            for (int j = 0; j < len; j++) {
                char c1 = prev.charAt(j);
                char c2 = curr.charAt(j);
                if (c1 != c2) {
                    Set<Character> children = edges.containsKey(c1) ? edges.get(c1) : new HashSet<>();
                    if (!children.contains(c2)) {
                        children.add(c2);
                        edges.put(c1, children);
                        degrees.put(c2, degrees.get(c2) + 1);
                    }
                    break;
                }
            }
        }
        
        Queue<Character> queue = new LinkedList<>();
        for (char c : degrees.keySet()) {
            if (degrees.get(c) == 0)
                queue.offer(c);
        }
        
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);
            if (edges.containsKey(c)) {
                for (char child : edges.get(c)) {
                    degrees.put(child, degrees.get(child) - 1);
                    if (degrees.get(child) == 0)
                        queue.offer(child);
                }
            }
        }
        
        if (sb.length() != degrees.size())
            return "";
        return sb.toString();
    }
}