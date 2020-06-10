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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
    
        // cut the list to two halves
        ListNode l1 = head; //head of first half
        ListNode slow = head; //head of second half
        ListNode fast = head; //tail of second half
        ListNode prev = null; //tail of first half

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }  
        prev.next = null;
        ListNode l2 = reverse(slow); // reverse the 2nd half
        merge(l1, l2); //merge the two halves
    }
    
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }   
    
    public void merge(ListNode l1, ListNode l2){
        while(l1!=null){
            ListNode l1Next = l1.next;
            ListNode l2Next = l2.next;
            l1.next = l2;
            
            if(l1Next == null) {
                break;
            }
            
            l2.next = l1Next;
            l1 = l1Next;
            l2 = l2Next;
        }
    }
}

/*
1-2-3-4-5-6 

//step 1: cut in two halves
1-2-3-null
4-5-6

//step 2: reverse second half
1-2-3-null
6-5-4

//step 3: merge
1-6-2-5-3-4
*/