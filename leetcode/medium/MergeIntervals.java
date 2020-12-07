class Solution {
    public int[][] merge(int[][] intervals) {
        // Sorting takes O(n log(n)) and merging the intervals takes O(n). So, the resulting algorithm takes O(n log(n)).
        //Input: [[1,3],[2,6],[8,10],[15,18]]
        //Output: [[1,6],[8,10],[15,18]]
        
        if(intervals.length<=1){
            return intervals;
        }
        
        Arrays.sort(intervals, (a1, a2) -> Integer.compare(a1[0], a2[0])); // Sort by ascending starting point
        
        List<int[]> result = new ArrayList<>(); //we don't know the size of output array so we use a list
        int[] currentInterval = intervals[0];
        result.add(currentInterval);
        
        for(int[] interval: intervals){
            if(currentInterval[1] >= interval[0]){  //if 3>2 in [1,3], [2,6]
                currentInterval[1] = Math.max(currentInterval[1], interval[1]); //take the max of 3,6 in [1,3], [2,6]
            } else {
                currentInterval = interval;
                result.add(currentInterval);
            }
        }
        return result.toArray(new int[result.size()][]); //return 2d array
    }
}
