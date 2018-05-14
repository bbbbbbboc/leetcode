// 210. Course Schedule II

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        
        if (numCourses <= 0 || prerequisites == null)
            return new int[0];
        
        List[] edges = new List[numCourses];
        int[] degrees = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<Integer>();
            degrees[i] = 0;
        }
        
        for (int[] i : prerequisites) {
            int toTake = i[0];
            int pre = i[1];
            edges[pre].add(toTake);
            degrees[toTake]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int idx = 0;
        
        for (int i = 0; i < numCourses; i++) {
            if (degrees[i] == 0) {
                queue.offer(i);
                visited.add(i);
                ans[idx++] = i;
            }
        }
        
        System.out.println(ans[0]);
        System.out.println(idx);
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            
            for (int i = 0; i < edges[curr].size(); i++) {
                int next = (int) edges[curr].get(i);
                degrees[next]--;
                if (degrees[next] == 0 && !visited.contains(next)) {
                    queue.offer(next);
                    visited.add(next);
                    ans[idx++] = next;
                }
            }
        }
        
        if (idx == numCourses)
            return ans;
        return new int[0];
    }
}