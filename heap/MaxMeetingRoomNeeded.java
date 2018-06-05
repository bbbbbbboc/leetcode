// 253. Meeting Rooms II
// time: O(n) space: O(n)
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
        int t;
        int status;
        Point(int t, int status) {
            this.t = t;
            this.status = status;
        }
    }

    class PointComparator implements Comparator<Point> {
        public int compare(Point p1, Point p2) {
            if (p1.t == p2.t)
                return p1.status - p2.status;
            return p1.t - p2.t;
        }
    }

    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;

        Queue<Point> pq = new PriorityQueue<>(new PointComparator());

        for (Interval i : intervals) {
            Point start = new Point(i.start, 1);
            Point end = new Point(i.end, 0);
            pq.offer(start);
            pq.offer(end);
        }

        int room = 0;
        int max = 0;
        while (!pq.isEmpty()) {
            Point p = pq.poll();
            System.out.print("time " + p.t);
            System.out.println(" status " + p.status);

            if (p.status == 0) {
                room--;
            } else {
                room++;
            }

            max = Math.max(max, room);
        }

        return max;
    }
}
