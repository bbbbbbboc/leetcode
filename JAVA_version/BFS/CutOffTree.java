// 675. Cut Off Trees for Golf Event

class Solution {
    int[] dx = new int[]{0, 1, 0, -1};
    int[] dy = new int[]{1, 0, -1, 0};
    
    public int cutOffTree(List<List<Integer>> forest) {
        List<int[]> trees = new ArrayList<>();
        
        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(i).size(); j++) {
                int height = forest.get(i).get(j);
                if (height > 1) 
                    trees.add(new int[]{height, i, j});
            }
        }
        
        Collections.sort(trees, (a, b) -> Integer.compare(a[0], b[0]));
        
        int steps = 0;
        int currRow = 0;
        int currCol = 0;
        
        for (int[] tree : trees) {
            int dis = getDis(forest, currRow, currCol, tree[1], tree[2]);
            if (dis == -1)
                return -1;
            steps += dis;
            forest.get(tree[1]).set(tree[2], 1);
            currRow = tree[1];
            currCol = tree[2];
        }
        
        return steps;
    }
    
    private int getDis(List<List<Integer>> forest, int sr, int sc, int tr, int tc) {
        int R = forest.size(), C = forest.get(0).size();
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{sr, sc, 0});
        boolean[][] seen = new boolean[R][C];
        seen[sr][sc] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == tr && cur[1] == tc) return cur[2];
            for (int di = 0; di < 4; ++di) {
                int r = cur[0] + dx[di];
                int c = cur[1] + dy[di];
                if (0 <= r && r < R && 0 <= c && c < C && !seen[r][c] && forest.get(r).get(c) > 0) {
                    seen[r][c] = true;
                    queue.add(new int[]{r, c, cur[2]+1});
                }
            }
        }
        return -1;
    }
}