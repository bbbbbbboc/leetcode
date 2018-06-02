// 356. Line Reflection

class Solution {
    public boolean isReflected(int[][] points) {
        
        if (points == null || points.length == 0)
            return true;
        
        Set<Integer> set = new HashSet<>();
        int sum;
        int maxX = Integer.MIN_VALUE;
        int minX = Integer.MAX_VALUE;
        
        for (int[] p : points) {
            maxX = Math.max(maxX, p[0]);
            minX = Math.min(minX, p[0]);
            set.add(Arrays.hashCode(p));
        }
        
        sum = maxX + minX;
        
        for (int[] p : points) {
            if (!set.contains(Arrays.hashCode(new int{sum - p[0], point[1]})))
                return false;
        }
        
        return true;
    }
}