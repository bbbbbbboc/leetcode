// 251. Flatten 2D Vector

public class Vector2D implements Iterator<Integer> {
    Iterator<List<Integer>> iter;
    Iterator<Integer> curr;
    
    public Vector2D(List<List<Integer>> vec2d) {
        iter = vec2d.iterator();
        if (iter.hasNext())
            curr = iter.next().iterator();
    }

    @Override
    public Integer next() {
        return curr == null ? null : curr.next();
    }

    @Override
    public boolean hasNext() {
        if (curr == null)
            return false;
        while (!curr.hasNext()) {
            if (!iter.hasNext())
                return false;
            curr = iter.next().iterator();
        }
        return true;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */