class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        //O(n) complexity, each element in the result doesn't have to be unique
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i: nums1){
           map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int k: nums2){
            if(map.containsKey(k)){
                if(map.get(k)>1){
                    map.put(k, map.get(k)-1);
                } else{
                    map.remove(k);
                }
                list.add(k);
            } 
        }
        
        int[] ans = new int[list.size()];
        int j = 0;
        while(j<ans.length){
            ans[j++] = list.get(j);
        }
        return ans;
    }
}



class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        //O(n) complexity, each element in the result must be unique
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>(); //to maintain unique list   
        
        for(int i: nums1){
           set.add(i);
        }
        
        for(int k: nums2){
            if(set.contains(k)){
                set2.add(k);
            }
        }
        
        int[] ans = new int[set2.size()];
        int j = 0;
        for(int i: set2){
            ans[j++] = i;
        }
        return ans;
    }
}