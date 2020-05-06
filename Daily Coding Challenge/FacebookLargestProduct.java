/*
This problem was asked by Facebook.

Given a list of integers, return the largest product that can be made by multiplying any three integers.

For example, if the list is [-10, -10, 5, 2], we should return 500, since that's -10 * -10 * 5.

You can assume the list has at least three integers.

*/


//n^3 time complexity 

public class FacebookLargestProduct{


    public static int LargestProduct(int[] nums){
       int maxproduct = Integer.MIN_VALUE; //smallest value possible 
       for(int i =0; i<nums.length - 2; i++){
           for(int j= i + 1 ; j<nums.length - 1 ; j++){
               for(int k = j + 1 ; k < nums.length; k++){
                   maxproduct = Math.max(maxproduct, nums[i] * nums[j] + nums [k] );
               }
           }
       }

       return maxproduct;

    }

    public static void main (String args[]){
        int[] numbers = {-10,-10,5,2};
        
        System.out.println(LargestProduct(numbers));
    }
}