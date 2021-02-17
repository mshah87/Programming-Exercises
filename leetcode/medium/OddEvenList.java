/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) { // In place O(n) complexity
        if(head == null || head.next == null){
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while(even!=null && even.next != null){
            odd.next = odd.next.next; // connect the odds
            even.next = even.next.next; // connect the evens
            odd=odd.next; // move pointer
            even=even.next; // move pointer
        }
        odd.next = evenHead; // connect end of odd list to start of even list
        return head;
    }
}
