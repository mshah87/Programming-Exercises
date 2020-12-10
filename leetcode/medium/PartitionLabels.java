class Solution {
    public List<Integer> partitionLabels(String S) { // O(n) time
        // if a letter appears in one part, it cannot appear in other parts
        if(S.length() == 0 || S == null){
            return null; 
        }
        
        List<Integer> result = new ArrayList<>();
        int[] lastIndices = new int[26]; // 0 meaning 'a' and 25 meaning 'z'
        for(int i = 0; i<S.length(); i++){
            lastIndices[S.charAt(i) - 'a'] = i; // adds last occurence of letter
        }
        
        //sliding window
        int start = 0;
        int end = 0;
        for(int i = 0; i<S.length(); i++){
            // end goes to last occurence of current letter
            end = Math.max(end, lastIndices[S.charAt(i) - 'a']); 
            if(i == end){ // found partition
                result.add(end - start + 1); // +1 because we want length not index wise
                start = end + 1;
            }
        }
        return result;
    }
}
