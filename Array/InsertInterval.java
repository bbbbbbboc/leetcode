// 57. Insert Interval

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int idx = 0;
        List<Interval> res = new ArrayList<>();
        
        if (intervals == null || intervals.size() == 0) {
            res.add(newInterval);
            return res;
        }
        while (idx < intervals.size() && intervals.get(idx).end < newInterval.start) {
            res.add(intervals.get(idx++));
        }
        
        while (idx < intervals.size() && intervals.get(idx).start <= newInterval.end) {
            newInterval = new Interval(Math.min(newInterval.start, intervals.get(idx).start), Math.max(newInterval.end, intervals.get(idx).end));
            idx++;
        }
        
        res.add(newInterval);
        
        while (idx < intervals.size()) {
            res.add(intervals.get(idx++));
        }
        
        return res;
    }
}