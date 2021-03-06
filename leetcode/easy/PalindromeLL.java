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

// 1 2 3 3 2 1 -> reverse second half -> 1 2 3 1 2 3, fast = head and slow = middle 
class Solution { // O(n) complexity, O(1) space
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast!=null && fast.next!=null){
            slow=slow.next; // goes to the middle
            fast=fast.next.next; //goes to the end
        }
        
        slow = reversed(slow); // goes to head of reversed list (middle)
        fast = head; // start of list
        while(slow!=null){
            if(slow.val != fast.val){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;    
    }
    
    public ListNode reversed(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}
