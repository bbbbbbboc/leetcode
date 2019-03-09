// 296. Best Meeting Point

class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        List<Integer> people = new ArrayList<>();
        int n = grid.length;
        int m = grid[0].length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    rows.add(i);
                    cols.add(j);
                    people.add(i * m + j);
                }
            }
        }
        
        Collections.sort(cols);
        int rowMedian = rows.get(rows.size() / 2);
        int colMedian = cols.get(cols.size() / 2);
        
        return calculateDistance(people, rowMedian, colMedian, m);
    }
    
    private int calculateDistance(List<Integer> people, int rowMedian, int colMedian, int m) {
        int dis = 0;
        for (int i : people) {
            dis += (Math.abs(i / m - rowMedian) + Math.abs(i % m - colMedian)); 
        }
        return dis;
    }
}