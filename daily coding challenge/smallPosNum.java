import java.util.HashSet;

public class smallPosNum{

    //For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.

    public int firstMissingPositive(int[] nums) {

        //solution 1

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