// 146. LRU Cache

class LRUCache {
    class Node {
        int key;
        int val;
        Node prev;
        Node next;
    }
    
    Node dummyH;
    Node dummyT;
    int cap;
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        dummyH = new Node();
        dummyT = new Node();
        dummyH.next = dummyT;
        dummyT.prev = dummyH;
        cap = capacity;
        map = new HashMap<>();
    }
    
    private void removeNode(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }
    
    private void addToHead(Node n) {
        n.prev = dummyH;
        n.next = dummyH.next;
        dummyH.next.prev = n;
        dummyH.next = n;
    }
    
    private void removeTail() {
        Node n = dummyT.prev;
        removeNode(n);
        map.remove(n.key);
    }
    
    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        Node n = map.get(key);
        removeNode(n);
        addToHead(n);
        return n.val;
    }
    
    public void put(int key, int value) {
        Node n = map.get(key);
        if (n != null) {
            n.val = value;
            removeNode(n);
            addToHead(n);
        } else {
            n = new Node();
            n.key = key;
            n.val = value;
            map.put(key, n);
            addToHead(n);
            
            if (map.size() > cap) 
                removeTail();
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */