// 295. Find Median from Data Stream

class MedianFinder {
    Queue<Long> minHeap;
    Queue<Long> maxHeap;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxHeap.offer((long) num);
        minHeap.offer(-maxHeap.poll());
        if (maxHeap.size() < minHeap.size()) 
            maxHeap.offer(-minHeap.poll());
    }
    
    public double findMedian() {
        return maxHeap.size() > minHeap.size() ? maxHeap.peek() : (maxHeap.peek() - minHeap.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */