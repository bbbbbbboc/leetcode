// 433. Minimum Genetic Mutation

class Solution {
    public int minMutation(String start, String end, String[] bank) {
        int step = 0;
        char[] bankset = new char[]{'A', 'T', 'G', 'C'};
        Set<String> set = new HashSet<>();
        for (String s : bank)
            set.add(s);
        
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                
                if (curr.equals(end)) {
                    return step;
                }
                char[] arr = curr.toCharArray();
                for (int j = 0; j < arr.length; j++) {
                    char old = arr[j];
                    for (int k = 0; k < 4; k++) {
                        arr[j] = bankset[k];
                        String next = new String(arr);
                        if (!visited.contains(next) && set.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                    arr[j] = old;
                }
            }
            
            step++;
        }
        
        return -1;
    }
}