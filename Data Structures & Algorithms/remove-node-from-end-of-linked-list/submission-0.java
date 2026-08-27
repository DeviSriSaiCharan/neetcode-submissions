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
    private void removeNode(ListNode prev, ListNode targetNode) {
        if(targetNode == null) return ;

        prev.next = targetNode.next;
        targetNode.next = null;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;

        ListNode ptr = head;
        while(ptr != null) {
            len++;
            ptr = ptr.next;
        }

        int target = len - n;

        ptr = head;
        ListNode prev = null;

        if(target == 0) return head.next;

        while(target > 0) {
            prev = ptr;
            ptr = ptr.next;
            target--;
        }

        removeNode(prev, ptr);

        return head;
    }
}
