class Solution {
    public int findKthLargest(int[] nums, int k) {
        // (N lg K) running time + O(K) memory
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i: nums){
            minHeap.add(i);
            if(minHeap.size() > k){ // heap only stores k numbers
                minHeap.remove(); // remove from root (smallest element)
            }
        }
        return minHeap.remove(); // root will have kth largest element at the end
    }
}
