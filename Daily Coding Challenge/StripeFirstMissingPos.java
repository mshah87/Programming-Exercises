// This problem was asked by Stripe.

// Given an array of integers, find the first missing positive integer in linear time and constant space.
// In other words, find the lowest positive integer that does not exist in the array.
// The array can contain duplicates and negative numbers as well.

// For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.

// You can modify the input array in-place.

import java.util.HashSet;

public class StripeFirstMissingPos{

    public int firstMissingPositive(int[] nums) {

        int smallest = 1;
        HashSet<Integer> set = new HashSet<Integer>();

        if(nums.length == 0){
            return smallest;
        }

        for(int i =0; i< nums.length; i++){

            if(num[i]> 0){
                set.add(nums[i]);
            }
        }

        while(set.contains(smallest)){
             smallest++;
        }
        return smallest;
    }
}