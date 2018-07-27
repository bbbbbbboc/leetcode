// 165. Compare Version Numbers

class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        
        int len = Math.max(v1.length, v2.length);
        
        for (int i = 0; i < len; i++) {
            Integer v1Curr = i < v1.length ? Integer.valueOf(v1[i]) : 0;
            Integer v2Curr = i < v2.length ? Integer.valueOf(v2[i]) : 0;
            int compare = v1Curr.compareTo(v2Curr);
            if (compare != 0)
                return compare;
        }
        
        return 0;
    }
}