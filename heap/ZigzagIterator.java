// 281. Zigzag Iterator

public class ZigzagIterator {
    Queue<Iterator> iters;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        iters = new LinkedList<>();
        if (v1.size() > 0) {
            iters.offer(v1.iterator());
        }
        if (v2.size() > 0) {
            iters.offer(v2.iterator());
        }
    }

    public int next() {
        Iterator curr = iters.poll();
        int res = (int) curr.next();
        if (curr.hasNext())
            iters.offer(curr);
        return res;
    }

    public boolean hasNext() {
        return !iters.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */