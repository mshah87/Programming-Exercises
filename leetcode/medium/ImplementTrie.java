class TrieNode {
    public HashMap<Character, TrieNode> children = new HashMap<>();
    public Boolean end = false;
    public void putChildIfAbsent(char c){
        children.putIfAbsent(c, new TrieNode());
    }
    public TrieNode getChild(char c){
        return children.get(c);
    }
}

class Trie {
    //insert(): O(n)
    //search(): O(n)
    //startsWith(): O(n)
    private TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            curr.putChildIfAbsent(c);
            curr = curr.getChild(c);
        }
        curr.end = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            curr = curr.getChild(c);
            if(curr == null){
                return false;
            }
        }
        return curr.end;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char c: prefix.toCharArray()){
            curr = curr.getChild(c);
            if(curr == null){
                return false;
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */