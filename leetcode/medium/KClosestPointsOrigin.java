class Solution {
    public int[][] kClosest(int[][] points, int K) {
        // O(nlogk) time
        // euclidean distance
        // maxheap top elements will contain points that are farther away from origin
        // we will get rid of them by polling and keeping the size K
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((p1, p2) -> (p2[0] * p2[0] + p2[1] * p2[1]) - (p1[0] * p1[0] + p1[1] * p1[1]));
        
        for(int[] point: points){
            maxHeap.offer(point);
            if(maxHeap.size() > K){ // only k elements in maxheap, at the end there will be k elements closest to origin
                maxHeap.poll();
            }
        }
        
        int[][] result = new int[K][2];
        while(K-- > 0){
            result[K] = maxHeap.poll();
        }
        return result;
    }
}
