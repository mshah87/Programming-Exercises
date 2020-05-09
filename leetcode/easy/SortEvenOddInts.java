class Solution {
    //O(n) Complexity
    public int[] sortArrayByParity(int[] A) {
        int[] result = new int[A.length];
        int j = 0, k = A.length-1;
        for(int i = 0; i< A.length; i++){
            if(A[i] %2 == 0){
                result[j++] = A[i];
            } else {
                result[k--] = A[i];
            }
        }
        return result;
    }
}