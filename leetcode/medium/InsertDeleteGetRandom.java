class RandomizedSet { // O(1) function calls
    private HashMap<Integer, Integer> map; 
    private List<Integer> list; // resizeable 
    private Random random;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) return false; // val already in map, no need to insert
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false; // val not in map, cannot remove
        int index = map.get(val); // extract index of val that we will remove
        int lastElement = list.get(list.size() - 1); // extract last elem of list
        list.set(index, lastElement); // overwrite val with last elem
        map.put(lastElement, index); // update entry in map
        map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int index = random.nextInt(list.size()); // 0 to list.size - 1, equal probability 
        return list.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

 // brute force: only use set, then convert set to list when calling getRandom(), making the random call O(N)
 