class MedianFinder {
    // O(log(n)) of add() and O(1) of getMedian()
    //We can use two heaps to store the lower half and the higher half of the data stream. 
    //The size of the two heaps differs at most 1.
    // https://www.programcreek.com/2015/01/leetcode-find-median-from-data-stream-java/

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> (b-a));

    /** initialize your data structure here. */
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());
        if(minHeap.size() < maxHeap.size()){
            minHeap.offer(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        if(minHeap.size() > maxHeap.size()){
            return minHeap.peek();
        } else {
            return (minHeap.peek() + maxHeap.peek())/2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
