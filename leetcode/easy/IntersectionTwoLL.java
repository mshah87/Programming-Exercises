/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// explanation of solution: https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49785/Java-solution-without-knowing-the-difference-in-len!
public class Solution { //One Pass: O(n) complexity, O(1) space
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode a = headA, b = headB;
        while(a!=b){
            if(a == null) {
                a = headB;
            } else {
               a = a.next;
            }
            if(b == null) {
                b = headA;
            } else {
                b = b.next;
            }
        }
        return a;
    }
}