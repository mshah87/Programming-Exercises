class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // O(klogn) time, O(k) space, where k is # elements in heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> (b-a));
        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[i].length; j++){
                maxHeap.offer(matrix[i][j]);
                if(maxHeap.size() > k){
                    maxHeap.poll(); // keep heap size at most k
                }
            }
        }
        return maxHeap.poll();
    }
}

// more efficient: modified binary search
// O(nlogm) time where m = max - min
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int r = matrix.length;
        int c = matrix[0].length;
        int low = matrix[0][0];
        int high = matrix[r-1][c-1];
        while(low<=high){
            int mid = low + (high-low)/2;
            int count = countNums(matrix, mid);
            if(count < k){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
    
    // find the number of elements in the matrix that are smaller or equal to mid
    private int countNums(int[][] matrix, int mid){
        int count = 0; 
        int i = 0;
        int j = matrix[0].length-1; // top right corner
        while(i<matrix.length && j>=0){
            if(matrix[i][j] <= mid){
                count = count + j + 1;
                i++;
            } else {
                j--;
            }
        }
        return count;
    }
}
