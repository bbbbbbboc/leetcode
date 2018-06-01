// 369. Plus One Linked List

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode plusOne(ListNode head) {
        if (head == null)
            return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        
        while (fast.next != null) {
            fast = fast.next;
            if (fast.val != 9)
                slow = fast;
        }
        
        if (fast.val != 9) {
            fast.val++;
            return dummy.next;
        } 
        
        slow.val++;
        slow = slow.next;
        
        while (slow != null) {
            slow.val = 0;
            slow = slow.next;
        }
        
        if (dummy.val == 0)
            return dummy.next;
        
        return dummy;
    }
}