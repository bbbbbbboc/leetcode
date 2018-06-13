// 127. Word Ladder

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> bank = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        
        int steps = 1;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(endWord))
                    return steps;
                
                char[] arr = curr.toCharArray();
                for (int j = 0; j < arr.length; j++) {
                    char old = arr[j];
                    
                    for (int k = 0; k < 26; k++) {
                        if ((char) (k + 'a') == old)
                            continue;
                        arr[j] = (char) (k + 'a');
                        String next = new String(arr);
                        if (!visited.contains(next) && bank.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                            System.out.println(next);
                        }
                    }
                    
                    arr[j] = old;
                }
            }
            
            steps++;
        }
        
        return 0;
    }
}