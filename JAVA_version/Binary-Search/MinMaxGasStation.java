// 774. Minimize Max Distance to Gas Station
// count is the number of gas station we need to make it possible.

class Solution {
    public double minmaxGasDist(int[] stations, int K) {
        int count;
        int N = stations.length;
        
        double left = 0;
        double right = stations[N - 1] - stations[0];
        
        while (left + 1e-6 < right) {
            double mid = left + (right - left) / 2;
            count = 0;
            for (int i = 0; i < N - 1; i++) {
                count += (Math.ceil((stations[i + 1]- stations[i]) / mid) - 1);
            }
            if (count > K) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        return right;
    }
}