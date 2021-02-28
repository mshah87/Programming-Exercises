class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // https://www.youtube.com/watch?v=KukNnoN-SoY&ab_channel=TimeComplexityInfinity
        
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }
    
    public void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums){
        if(tempList.size() == nums.length){
            /* 
            tempList is a list that is used throughout all the recursive calls to keep track of the 
            current recursion path. When we finally reach the base case, we cannot add this same list 
            to the list of lists. This is because when you add tempList, you are adding a reference to 
            tempList. This means that other recursive paths can modify the path you just inserted into the final list of lists.
            */
            list.add(new ArrayList<>(tempList));
        } else {
            for(int i = 0; i<nums.length; i++){
                if(tempList.contains(nums[i])) { // elem already exists, skip
                    continue;
                }
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                
                /*
                remove the least recently added element while we are going up the recursive call
                stack. In the first iteration of the for loop we add all permutations, that start with nums[0]. 
                Then, before we can begin building all permutations starting with nums[1], we need to clear the 
                tempList (which currently contains permutations from the first iteration of the for loop) 
                */
                tempList.remove(tempList.size() - 1); 
            }
        }
        
    }
}
