// 755. Pour Water

class Solution {
    public int[] pourWater(int[] heights, int V, int K) {
        while (V-- > 0) droplet: {
            for (int d = -1; d <= 1; d += 2) {
                int i = K;
                int best = K;
                while (0 <= i + d && i + d < heights.length && heights[i + d] <= heights[i]) {
                    if (heights[i + d] < heights[i])
                        best = i + d;
                    i += d;
                }
                
                if (heights[best] < heights[K]) {
                    heights[best]++;
                    break droplet;
                }
            }
            heights[K]++;
        }
        
        return heights;
    }
}

/*
We attempt to perform the steps directly as described.

First, notice that an index with terrain or with water is indistinguishable with respect to the flow of water. 
Thus, we can model heights as the total level of terrain and water directly as we perform our simulation.

When a droplet falls, we should check if it is possible for it to fall left. 
For our left pointer i = K, if i - 1 is in bounds and heights[i - 1] <= heights[i], 
the water will fall to a candidate block in that direction. 
We keep track of every time we actually fall at index best. 
If we "eventually fall" (best != K) as described in the problem statement, then we will drop the water there.

Otherwise, (if moving left will not cause the droplet to eventually fall), 
 we can perform a similar check for i = K going right, and otherwise the droplet stays in place.

For convenience, we will name the initial array H = heights.
*/