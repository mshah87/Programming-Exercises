class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {        
        //O(n) complexity, slow/fast runner approach 
        if(head == null){ //check if head is null
            return null;
        } 
        
        ListNode start = new ListNode(0); 
        ListNode slow = start;
        ListNode fast = start;
        start.next = head;
        
        for(int i = 0 ; i<n ; i++){ //move fast pointer such that the gap between fast and slow pointer is n nodes 
            fast = fast.next;
        }
        
        while(fast.next != null){ //move fast pointer until it's null, maintaining the gap 
            fast = fast.next; 
            slow = slow.next;
        }
        
        slow.next = slow.next.next; //Skip the desired node
        return start.next; //return head
    }
}