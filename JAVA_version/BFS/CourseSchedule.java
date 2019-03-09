// 207. Course Schedule

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null || prerequisites.length == 0)
            return true;
        
        List[] edges = new ArrayList[numCourses];
        int[] degrees = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
            int preq = prerequisites[i][1];
            int toTake = prerequisites[i][0];
            
            degrees[toTake]++;
            edges[preq].add(toTake);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        
        for (int i = 0; i < numCourses; i++) {
            if (degrees[i] == 0)
                queue.offer(i);
        }
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            count++;
            
            int size = edges[curr].size();
            for (int i = 0; i < size; i++) {
                int toTake = (int) edges[curr].get(i);
                degrees[toTake]--;
                if (degrees[toTake] == 0)
                    queue.offer(toTake);
            }
        }
        
        return count == numCourses;
    }
}