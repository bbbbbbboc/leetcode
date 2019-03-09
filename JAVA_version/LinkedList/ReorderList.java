// 143. Reorder List

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // reverse the second half
        // 1->2->3->4->5 ---> 1->2->3->5->4
        ListNode preMid = slow; // 3
        ListNode preCurr = slow.next; // 5
        while (preCurr.next != null) {
            ListNode curr = preCurr.next;
            preCurr.next = curr.next;
            curr.next = preMid.next;
            preMid.next = curr;
        }
        
        // start reordering
        // 1->2->3->5->4 ---> 1->5->2->4->3
        ListNode l1 = head;
        ListNode l2 = preMid.next;
        while (l1 != preMid) {
            preMid.next = l2.next;
            l2.next = l1.next;
            l1.next = l2;
            l1 = l2.next;
            l2 = preMid.next;
        }
    }
}