/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> st = new HashSet<>();
        int ans = 0;
        for (int g : G) {
            st.add(g);
        }
        boolean has = false;
        while (head !=  null) {
            if (!has && st.contains(head.val)) {
                has = true;
                ans++;
            }
            if (!st.contains(head.val)) {
                has = false;
            }
            head = head.next;
        }
        return ans;
    }
}
