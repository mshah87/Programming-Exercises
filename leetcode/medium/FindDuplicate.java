class Solution {
    public int findDuplicate(int[] nums) { 
        // O(N) time, O(1) space, also cannot modifying array
        // linkedlist cycle method: https://www.youtube.com/watch?v=32Ll35mhWg0&ab_channel=takeUforward
        int slow = 0;
        int fast = 0;
        do { 
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow!=fast); // slow runs one step, fast runs two steps, stop until they meet
        
        slow = 0; // set slow to start of cycle
        while(slow!=fast){ 
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow; // the element they meet at is the duplicate
    }
}

// other methods 
// 1.) sort and loop: O(nlogn), O(1) space
// 2.) hashmap: O(n) time, O(n) space
