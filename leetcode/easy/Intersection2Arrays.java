class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i: nums1){
            if(!map.containsKey(i)){
                map.put(i,1);
            } else {
                map.put(i,map.get(i)+1);
            }
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
        
        int ans[] = new int[list.size()];
        int j = 0;
        while(j<ans.length){
            ans[j] = list.get(j);
            j++;
        }
        
        return ans;
        
        
    }
}