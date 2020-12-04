class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Time: O(26*M*N), where M is the length of words and N is the total number of words in the input word list
        // Space: O(M*N)
        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;
        
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int level = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                String word = q.poll();
                if(word.equals(endWord)) return level;
                for(int j = 0; j<word.length(); j++){
                    char[] charWord = word.toCharArray();
                    for(char c = 'a'; c<='z'; c++){ // all possible combos with alphabet
                        charWord[j] = c;
                        String newWord = new String(charWord);
                        if(set.contains(newWord) && !newWord.equals(word)) { // making sure newWord doesn't equal old word while transforming. Don't want to process same word again
                            q.offer(newWord);
                            set.remove(newWord); // we marked newWord as visited, so remove from set. Avoid duplicates
                        }
                    }
                } 
            }
            level++;
        }
        return 0;
    }
}
