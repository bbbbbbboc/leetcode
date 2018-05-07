// 19. Remove Nth Node From End of List

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode second = dummy;
        ListNode first = dummy;
        int count = 0;
        
        while (count < n) {
            second = second.next;
            count++;
        }
        
        while (second.next != null) {
            first = first.next;
            second = second.next;
        }
        
        first.next = first.next.next;
        return dummy.next;
    }
}