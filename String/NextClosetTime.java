// 681. Next Closest Time

class Solution {
    public String nextClosestTime(String time) {
        int start = 60 * Integer.parseInt(time.substring(0, 2));
        start += Integer.parseInt(time.substring(3));
        
        int ans = start;
        int elapsed = 24 * 60;
        
        Set<Integer> allowed = new HashSet<>();
        for (char c : time.toCharArray()) {
            if (c != ':')
                allowed.add(c - '0');
        }
        
        for (int h1 : allowed) {
            for (int h2 : allowed) {
                if (h1 * 10 + h2 >= 24)
                    continue;
                
                for (int m1 : allowed) {
                    for (int m2 : allowed) {
                        if (m1 * 10 + m2 >= 60)
                            continue;
                        
                        int curr = 60 * (10 * h1 + h2) + (10 * m1 + m2);
                        int candElapsed = Math.floorMod(curr - start, 24 * 60);
                        
                        if (0 < candElapsed && candElapsed < elapsed) {
                            ans = curr;
                            elapsed = candElapsed;
                        }
                    }
                }
            }
        }
        
        return String.format("%02d:%02d", ans / 60, ans % 60);
    }
}