/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode node) {
        ListNode head = null, tail = node;
        while (tail != null) {
            ListNode temp = tail.next;
            tail.next = head;
            head = tail;
            tail = temp;
        }
        return head;
    }
}
