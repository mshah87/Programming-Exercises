import java.util.HashSet;

/*
This problem was asked by Microsoft.

Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example, given [100, 4, 200, 1, 3, 2], the longest consecutive element sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
*/

//METHOD 1: sort array then determine the sequence of consecutive numbers
//Time complexity: O(nlogn, dominated by Arrays.sort()
//Space: O(1), sorting it in place

//METHOD 2: Hashset
//Time complexity: O(n)
//Space: O(n), uses set as storage 

public class MicrosoftLongConsecNum {

    public static int LongConsec(int[] nums){

        //if length 0, then there are no consecutive numbers
        if(nums.length == 0){
            return 0;
        }

        HashSet<Integer> set = new HashSet<Integer>();
        int max = 1;

        //add all numbers in array to the set
        for(int i: nums){
            set.add(i);
        }

        //variables for left of number and right of number
        for(int i: nums){
            int count  = 1;
            int l = i - 1; 
            int r = i + 1; 

            while(set.contains(l)){
               count++;
               set.remove(l);
               l--; 
            }

            while(set.contains(r)){
                count++;
                set.remove(r);
                r++;
            }
            max = Math.max(max, count);

        }

        return max;

        
    }

    public static void main (String args[]){

        int[] nums = {100, 4, 200, 1, 3, 2};

        System.out.println(LongConsec(nums));
    }
}
