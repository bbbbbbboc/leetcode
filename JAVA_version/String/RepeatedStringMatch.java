// 686. Repeated String Match

class Solution {
    public int repeatedStringMatch(String A, String B) {

        int repeat = 1;
        StringBuilder sb = new StringBuilder(A);
        
        while (sb.length() < B.length()) {
            sb.append(A);
            repeat++;
        }
        
        if (sb.indexOf(B) >= 0) 
            return repeat;
        if (sb.append(A).indexOf(B) >= 0) 
            return repeat + 1;
        return -1;
    }
}