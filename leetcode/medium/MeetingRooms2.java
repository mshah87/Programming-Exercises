class Solution {
    public int minMeetingRooms(int[][] intervals) { // O(nlogn) time O(n) space
        if(intervals == null || intervals.length ==0){
            return 0;
        }
        
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0])); // sort by starting time
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // stores end times
        minHeap.offer(intervals[0][1]);
        for(int i = 1; i<intervals.length; i++){
            if(intervals[i][0] >= minHeap.peek()){
                minHeap.poll(); // no conflict, we can free this room for next intervals[i]
            }
            minHeap.offer(intervals[i][1]);
        }
        return minHeap.size(); // gives minimum number of rooms
    }
}
