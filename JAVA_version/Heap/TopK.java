// 347. Top K Frequent Elements
// time: O(n) space O(n)
class Solution {
    class Pair {
        int val;
        int freq;

        Pair(int val) {
            this.val = val;
            this.freq = 1;
        }

        void increment() {
            this.freq++;
        }
    }

    class PairComparator implements Comparator<Pair> {
        public int compare(Pair a, Pair b) {
            return a.freq - b.freq;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();

        if (nums == null || nums.length == 0 || k < 1)
            return ans;

        Queue<Pair> pq = new PriorityQueue<>(k, new PairComparator());
        Map<Integer, Pair> map = new HashMap<>();

        for (int i : nums) {
            if (map.containsKey(i)) {
                Pair p = map.get(i);
                pq.remove(p);
                p.increment();
                pq.offer(p);
            } else {
                Pair p = new Pair(i);
                map.put(i, p);
                pq.offer(p);
            }
            if (pq.size() > k)
                pq.poll();
        }

        while (!pq.isEmpty()) {
            ans.add(0, pq.poll().val);
        }

        return ans;
    }
}
