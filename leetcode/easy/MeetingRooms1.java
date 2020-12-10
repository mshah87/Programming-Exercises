class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length == 0 || intervals == null){
            return true;
        }
        
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0])); // sort by starting time
        for(int i = 0; i<intervals.length - 1; i++){
            if(intervals[i][1] > intervals[i+1][0]){ //if end time > start time of next slot, overlapping
                return false;
            }
        }
        return true;
    }
}