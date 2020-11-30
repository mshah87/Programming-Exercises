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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) { //O(n) time
        ListNode result = new ListNode(0);
        ListNode dummy = result;
        int sum = 0;
        
        while(l1!=null || l2!=null){
            
            sum = sum/10; //figure out carry 
            
            if(l1 != null){
                sum+=l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum+=l2.val;
                l2 = l2.next;
            }
                        
            dummy.next = new ListNode(sum%10); //last digit -> 6+4=10, 1 is carry and 0 is the last digit
            dummy = dummy.next;
        }
        
        if(sum/10 > 0){ //could have carry left over -> 900+900=1800, create new place value for 1 
            dummy.next = new ListNode(sum/10);
        }
        return result.next;
    }
}
