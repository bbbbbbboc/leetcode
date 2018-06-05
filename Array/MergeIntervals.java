// 56. Merge Intervals
// time: O(nlogn) space: O(1)/(n)
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
    public List<Interval> merge(List<Interval> intervals) {
        LinkedList<Interval> ans = new LinkedList<>();
        Collections.sort(intervals, new Comparator<Interval>() {
           public int compare(Interval i1, Interval i2) {
               return i1.start - i2.start;
           }
        });

        for (Interval i : intervals) {
            if (ans.size() == 0 || ans.getLast().end < i.start) {
                ans.add(i);
            } else {
                ans.getLast().end = Math.max(ans.getLast().end, i.end);
            }
        }
        return ans;
    }

}
