// 252. Meeting Rooms
// time: O(n), space: O(n)

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

    class Point {
        int t, status;
        Point(int t, int status) {
            this.t = t;
            this.status = status;
        }
    }
    class PointComparator implements Comparator<Point> {
        public int compare(Point a, Point b) {
            if (a.t == b.t) {
                return a.status - b.status;
            }
            return a.t - b.t;
        }
    }

    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length == 0)
            return true;

        Queue<Point> pq = new PriorityQueue<>(new PointComparator());

        for (Interval i : intervals) {
            int start = i.start;
            int end = i.end;
            pq.offer(new Point(start, 1));
            pq.offer(new Point(end, 0));
        }

        boolean available = true;
        int lastMeetingTime;

        while (!pq.isEmpty()) {
            Point p = pq.poll();
            if (!available) {
                if (p.status == 0) {
                    return false;
                } else {
                    available = true;
                }
            } else {
                if (p.status == 0) {
                    available = false;
                }
            }
        }

        return true;
    }




    // version 2
    public boolean canAttendMeetings(Interval[] intervals) {
      Arrays.sort(intervals, new Comparator<Interval>() {
          public int compare(Interval i1, Interval i2) {
              return i1.start - i2.start;
          }
      });
      for (int i = 0; i < intervals.length - 1; i++) {
          if (intervals[i].end > intervals[i + 1].start) return false;
      }
      return true;
    }
}
