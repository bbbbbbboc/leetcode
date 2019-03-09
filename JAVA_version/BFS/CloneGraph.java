// 133. Clone Graph

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;
        
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        Set<UndirectedGraphNode> visited = new HashSet<>();
        visited.add(node);
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode old = queue.poll();
            map.put(old, new UndirectedGraphNode(old.label));
            
            for (UndirectedGraphNode nei : old.neighbors) {
                if (!visited.contains(nei)) {
                    queue.offer(nei);
                    visited.add(old);
                }
            }
        }
        
        for (UndirectedGraphNode old : map.keySet()) {
            UndirectedGraphNode newNode = map.get(old);
            for (UndirectedGraphNode oldNei : old.neighbors) {
                newNode.neighbors.add (map.get(oldNei));
            }
        }
        
        return map.get(node);
    }
}