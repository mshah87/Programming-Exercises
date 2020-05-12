//Hashmap and doublyLL: O(1) complexity, fast lookup and fast removal/addition
class LRUCache {
    Node head = new Node();
    Node tail = new Node();
    Map<Integer, Node> map;
    int capacity; 
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) { //if the node is present, remove it and add it to the front of LL (since we used it)
        Node node = map.get(key);
        if(node!=null){
            remove(node);
            add(node);
            return node.val;
        }
        return -1;  
    }
    
    public void put(int key, int value) { 
        Node node = map.get(key);
        if(node!= null){ //if node present, remove it, set the new value, and add the node to front
            remove(node); 
            node.val = value;
            add(node); 
        } else { //if map size equals capacity, remove node from map and LL
            if(map.size() == capacity){
                map.remove(tail.prev.key);
                remove(tail.prev);
            } 
                Node newNode = new Node(); //then add the new node to the map and LL
                newNode.key = key;
                newNode.val = value;
                map.put(key, newNode);
                add(newNode);
        }
    }
    
    public void add(Node node){ //add to front
        Node nextNode = head.next;
        node.next = nextNode;
        nextNode.prev = node;
        head.next = node;
        node.prev = head;
    }
    
    public void remove(Node node){ //remove from end
        Node nextNode = node.next;
        Node prevNode = node.prev;
        nextNode.prev = prevNode;
        prevNode.next = nextNode;
    }
    
    class Node {
        int key; 
        int val;
        Node prev;
        Node next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */