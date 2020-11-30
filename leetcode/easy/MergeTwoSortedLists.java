/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) { //O(n) time
        ListNode list = new ListNode(0);
        ListNode h = list;
        
        while(l1!=null && l2!=null){
            if(l1.val < l2.val){
                h.next = l1;
                l1 = l1.next;
            } else {
                h.next = l2;
                l2 = l2.next;
            }
            h=h.next;
        }
        
        if(l1 != null){
            h.next = l1;
        } else if(l2!=null){
            h.next = l2;
        }
     
        return list.next;
    }
}