/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) { // O(n) time O(n) space
        if(head == null) return null;
        
        HashMap<Node, Node> map = new HashMap<>(); // HashMap which holds old node as key and new clone as value
        
        Node curr = head;
        while(curr != null){
            map.put(curr, new Node(curr.val)); //copy list nodes into hash table
            curr = curr.next;
        }
        
        curr = head;
        while(curr != null){  //deep copy using hash table, assign next and random pointer of new clones
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head); //return new head
    }
}

// O(n) time, O(1) space
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        
        // step1: A->A'->B->B'->C->C'
        Node curr = head;
        while(curr!=null){
            Node copy = new Node(curr.val);
            Node temp = curr.next;
            curr.next = copy;
            copy.next = temp;
            curr = temp;
        }
        
        // step2: assign the random links, n'.random = n.random.next
        curr = head;
        while(curr!=null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
            } else {
                curr.next.random = null;
            }
            curr = curr.next.next;
        }
        
        // step3: detach the list: n.next = n.next.next; n'.next = n'.next.next
        //restore original list and extract the copy list
        curr = head; //
        Node copy = head.next;
        Node res = head.next; // return this in the end
        while(curr!=null && copy != null){
            curr.next = curr.next.next;
            if(copy.next == null)
        		break;
            copy.next = copy.next.next;
            curr = curr.next;
            copy = copy.next;
        }
        return res;
    }
}
