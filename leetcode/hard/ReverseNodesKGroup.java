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
    public ListNode reverseKGroup(ListNode head, int k) { //O(n) time, O(1) space
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pointer = dummy;
        
        while(pointer!=null){
            ListNode node = pointer;
            
            // first check whether there are k nodes to reverse
            for(int i = 0; i<k && node!=null; i++){
                node = node.next;
            }
            if(node == null) break;
            
            //we have k nodes so lets start reversing from first node
            ListNode curr = pointer.next;
            ListNode prev = null;
            for(int i = 0; i<k; i++){
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            ListNode n = pointer.next;
            n.next = curr;
            pointer.next = prev;
            pointer = n;
        }
        return dummy.next;
    }
}
