// https://www.youtube.com/watch?v=9SnkdYXNIzM&ab_channel=MichaelMuinos

class Solution {
    public int firstMissingPositive(int[] nums) { // most efficient: O(n) complexity, O(1) space
        int n = nums.length;
        
        // step 1: change all -ve nums, 0, and nums greater than n to n+1
        // these nums are unnecessary bc we only care about numbers 1 - n
        for(int i = 0; i<n; i++){
            if(nums[i] <= 0 || nums[i] > n){
                nums[i] = n + 1;
            }
        }
        
        // now all nums in array are +ve in the range of 1 to n+1
        // step 2: map the number to its index and mark it as seen by changing to -ve
        for(int i = 0; i<n; i++){
            int num = Math.abs(nums[i]); 
            if(num > n){
                continue; // if the current number is n+1, move to next iteration of loop (mapping the index of n+1 would be out of bounds)
            }
            num--; // subtract 1 from num since the array is zero index based (ex. num=3 would map to index 2)
            if(nums[num] > 0){ // if current number is not -ve we gotta map it, otherwise we don't do any operation because we already mapped it
                nums[num] = nums[num] * -1;
            }
        }
        
        // step 3: loop through array again and find the first missing positive element
        for(int i = 0; i < n; i++){
            if(nums[i] > 0) {
                return i + 1; 
            }
        }
        
        // if no positive element found, array contains all numbers from 1...n, return n+1
        return n+1;
    }
}

/* 
other methods
1.) sort and loop: O(nlogn) time
2.) hashmap: O(n) time, O(n) space
*/
