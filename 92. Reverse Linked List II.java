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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        for(int i = 1; i<left;i++) {
            prev=prev.next;
        }
        ListNode curr = prev.next;
        ListNode next = null;
        ListNode prev2 = null;

        for(int i = 0; i < right - left + 1; i++) {
            next = curr.next;
            curr.next = prev2;
            prev2 = curr;
            curr = next;
        }
        prev.next.next = curr;
        prev.next = prev2;
        
        return dummy.next;
    }
}
