// 82. Remove Duplicates from Sorted List II

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy.next;
        ListNode prev = dummy;
        boolean dup = false;
        
        while (curr != null && curr.next != null) {
            
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
                dup = true;
            }
            
            if (dup) {
                prev.next = curr.next;
                curr = curr.next;
                dup = false;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        
        return dummy.next;
    }
}