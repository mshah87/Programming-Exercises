class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Time: O(26*M*N), where M is the length of words and N is the total number of words in the input word list
        // Space: O(M*N)
        HashSet<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;
    
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        set.remove(beginWord);
        int level = 1;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i<size; i++){
                String currWord = queue.poll();
                if(currWord.equals(endWord)) return level;
                for(int j = 0; j<currWord.length(); j++){
                    char[] chars = currWord.toCharArray();
                    for(char c ='a'; c<='z'; c++){ //change every char in word with the alphabet
                        chars[j] = c;
                        String newWord = String.valueOf(chars);
                        if(set.contains(newWord)){
                            queue.offer(newWord);
                            set.remove(newWord); //avoid duplicates
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}