// 264. Ugly Number II

class Solution {
    public int nthUglyNumber(int n) {
        int[] uglies = new int[n];
        int factor2 = 2;
        int factor3 = 3;
        int factor5 = 5;
        int idx2 = 0;
        int idx3 = 0;
        int idx5 = 0;
        uglies[0] = 1;

        for (int i = 1; i < n; i++) {
            int min = Math.min(factor2, Math.min(factor3, factor5));
            uglies[i] = min;

            if (factor2 == min)
                factor2 = 2 * uglies[++idx2];
            if (factor3 == min)
                factor3 = 3 * uglies[++idx3];
            if (factor5 == min)
                factor5 = 5 * uglies[++idx5];
        }

        return uglies[n - 1];
    }
}
