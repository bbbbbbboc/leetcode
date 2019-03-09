// 92. Reverse Linked List II

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null)
            return head;
        
        int idx = 1;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode curr = head;
        ListNode prev = dummy;
        
        while (idx != m) {
            prev = curr;
            curr = curr.next;
            idx++;
        }
        
        ListNode prevCopy = prev;
        ListNode currCopy = curr;
                
        while (idx != n + 1) {
            ListNode oldNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = oldNext;
            
            idx++;
        }
        
        prevCopy.next = prev;
        currCopy.next = curr;
        
        return dummy.next;
        
    }

}