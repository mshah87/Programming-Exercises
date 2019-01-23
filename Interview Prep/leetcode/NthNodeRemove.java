//#19 - medium 

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {        
        
        if(head == null){ //check if head is null
            return null;
        } 
        
        ListNode temp = new ListNode(0); //make temp node before the head
        temp.next = head;
    
        ListNode fast = temp;
        ListNode slow = temp;
        
        for(int i = 1 ; i<=n ; i++){ //move fast pointer such that the gap between fast and slow pointer is n nodes 
            fast = fast.next;
        }
        
        while(fast.next != null){ //move fast pointer until it's null, keeping the gap still
            fast = fast.next; 
            slow = slow.next;
        }
        
        slow.next = slow.next.next;
        
        return temp.next; //return head
        
    }
}