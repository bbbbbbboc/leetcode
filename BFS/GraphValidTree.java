// 261. Graph Valid Tree

class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (n <= 0 || edges.length != n - 1)
            return false;
        
        List[] myEdges = new List[n];
        for (int i = 0; i < n; i++) {
            myEdges[i] = new ArrayList<>();
        }
        
        for (int[] i : edges) {
            int a = i[0];
            int b = i[1];
            myEdges[a].add(b);
            myEdges[b].add(a);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(0);
        visited.add(0);
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int i = 0; i < myEdges[curr].size(); i++) {
                int nei = (int) myEdges[curr].get(i);
                if (!visited.contains(nei)) {
                    queue.offer(nei);
                    visited.add(nei);
                }
            }
        }
        
        return visited.size() == n;
    }
}


// V2 Union Find
class Solution {
    class UnionFind {
        int[] father;
        UnionFind(int n) {
            father = new int[n];
            for (int i = 0; i < n; i++) {
                father[i] = i;
            }
        }
        
        int findRoot(int n) {
            if (n == father[n])
                return n;
            return father[n] = findRoot(father[n]);
        }
        
        void connect(int a, int b) {
            int rootA = findRoot(a);
            int rootB = findRoot(b);
            if (rootA != rootB) {
                father[rootA] = rootB;
            }
        }
    }
    
    public boolean validTree(int n, int[][] edges) {
        if (n < 0 || edges.length != n - 1)
            return false;
        
        UnionFind uf = new UnionFind(n);
        for (int[] i : edges) {
            if (uf.findRoot(i[0]) == uf.findRoot(i[1]))
                return false;
            uf.connect(i[0], i[1]);
        }
        
        return true;
    }
}