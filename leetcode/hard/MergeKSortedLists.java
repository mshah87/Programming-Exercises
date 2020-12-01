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
    public ListNode mergeKLists(ListNode[] lists) {
        //O(nlogn) complexity since we're adding all nodes to minheap at once
        //optimization to O(nlogk): add first node of each linkedlist to minheap, this way max k elements will be in minheap
        if(lists == null || lists.length == 0) return null;
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(lists.length);
        for(ListNode node: lists){
            while(node != null){
                minHeap.offer(node.val);
                node = node.next;
            }
        }
        
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while(!minHeap.isEmpty()){
            curr.next = new ListNode(minHeap.poll());
            curr = curr.next;
        }
        
        return head.next;
    } 
}
