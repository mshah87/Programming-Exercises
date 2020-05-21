class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //Input: [[1,2],[2,3],[3,4],[1,3]]
        //Output: 1
        //Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
        if(intervals == null || intervals.length == 0){
            return 0;
        }
        
        Arrays.sort(intervals, (a1, a2) -> Integer.compare(a1[0], a2[0])); //sort by starting interval
        
        int intervalEnd = intervals[0][1];
        int count = 0;
        
        for(int i = 1; i<intervals.length; i++){
            if(intervalEnd > intervals[i][0]){  
                count++;
                intervalEnd = Math.min(intervalEnd, intervals[i][1]); //remove the interval with larger end 
            } else {
                intervalEnd = intervals[i][1];
            }
        }
        return count;
    }
}