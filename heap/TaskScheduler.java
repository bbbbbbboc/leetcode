// 621. Task Scheduler

class Solution {
    public int leastInterval(char[] tasks, int n) {
        Queue<Integer> pq = new PriorityQueue<>(26, Collections.reverseOrder());
        int[] map = new int[26];
        
        for (char c : tasks) {
            map[c - 'A']++;
        }
        
        for (int i : map) {
            if (i > 0)
                pq.offer(i);
        }
        
        int time = 0;
        
        while (!pq.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                if (!pq.isEmpty()) {
                    if (pq.peek() > 1) {
                        temp.add(pq.poll() - 1);
                    } else {
                        pq.poll();
                    }
                }
                time++;
                if (pq.isEmpty() && temp.size() == 0)
                    break;
            }
            
            for (int i : temp)
                pq.offer(i);
        }
        
        return time;
    }
}