// 635. Design Log Storage System

class LogSystem {
    Map<String, Integer> treeMap;
    Map<String, Integer> map;
    
    public LogSystem() {
        treeMap = new TreeMap<>();
        map = new HashMap<>();
        map.put("Year", 4);
        map.put("Month", 7);
        map.put("Day", 10);
        map.put("Hour", 13);
        map.put("Minute", 16);
        map.put("Second", 19);
    }
    
    public void put(int id, String timestamp) {
        treeMap.put(timestamp, id);
    }
    
    public List<Integer> retrieve(String s, String e, String gra) {
        List<Integer> ans = new ArrayList<>();
        int end = map.get(gra);
        s = s.substring(0, end);
        e = e.substring(0, end);
        
        for (String timestamp : treeMap.keySet()) {
            String t = timestamp.substring(0, end);
            if (t.compareTo(s) >= 0 && t.compareTo(e) <= 0)
                ans.add(treeMap.get(timestamp));
        }
        
        return ans;
    }
}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(s,e,gra);
 */