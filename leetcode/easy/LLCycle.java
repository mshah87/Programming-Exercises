/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        //slow/fast running approach. fast pointer runs twice as much as the slow pointer. 
        //if they both meet at one spot, the linkedlist is cyclic O(n)
        ListNode slow = head; 
        ListNode fast = head;
        
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast) return true;
        }
        return false;
    }
}

public class Solution {
    public boolean hasCycle(ListNode head) {
        //add all the nodes into hashmap, while iterating through linkedlist
        //if we encounter a node that is in the hashmap, the linkedlist is cyclic 0(n)
        Set<ListNode> set = new HashSet<>();
        while(head != null){
            if(!set.contains(head)){
                set.add(head);
            } else {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}