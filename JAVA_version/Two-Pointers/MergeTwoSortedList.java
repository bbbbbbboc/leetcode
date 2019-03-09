// 21. Merge Two Sorted Lists

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                curr.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            curr = curr.next;
        }
        
        while (l1 != null) {
            curr.next = new ListNode(l1.val);
            l1 = l1.next;
            curr = curr.next;
        }
        
        while (l2 != null) {
            curr.next = new ListNode(l2.val);
            l2 = l2.next;
            curr = curr.next;
        }
        
        return dummy.next;
    }
}