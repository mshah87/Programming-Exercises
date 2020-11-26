class Solution {
    public int[] productExceptSelf(int[] nums) {
        //O(n) time O(1) space
        int N = nums.length;
        int[] result = new int[N];
        result[0] = 1;
        
        for(int i = 1; i<N; i++){
            result[i] = result[i-1] * nums[i-1]; //result contains all left products
        }
        
        int right = 1; //keep a right variable for all right products
        for(int i = N-1; i>=0; i--){
            result[i] = result[i] * right;
            right = right * nums[i];
        }

        return result;
    }
}

class Solution {
    public int[] productExceptSelf(int[] nums) {
        //O(n) time O(n) space
        //get all left products and right products of ith number using two loops
        //in the end multiply the left and right product arrays at each index

        int N = nums.length;
        int[] left_products = new int[N];
        int[] right_products = new int[N];
        int[] result = new int[N];
        
        left_products[0] = 1;
        right_products[N-1] = 1;
        
        for(int i = 1; i<N; i++){
            left_products[i] = left_products[i-1] * nums[i-1];
        }
        
        for(int i = N-2; i>=0; i--){
            right_products[i] = right_products[i+1] * nums[i+1];
        }
        
        for(int i = 0; i<N; i++){
            result[i] = left_products[i] * right_products[i];
        }
        
        return result;
    }
}
