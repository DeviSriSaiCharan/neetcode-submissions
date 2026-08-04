/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    private int findLength(ListNode head) {
        ListNode temp = head;
        int len = 0;

        while(temp != null) {
            len++;
            temp = temp.next;
        }

        return len;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aLen = findLength(headA);
        int bLen = findLength(headB);

        ListNode tempA = headA;
        ListNode tempB = headB;

        if(aLen > bLen) {
            while(aLen != bLen) {
                tempA = tempA.next;
                aLen--;
            }
        } else if(aLen < bLen){
            while(aLen != bLen) {
                tempB = tempB.next;
                bLen--;
            }
        }

        while(tempA != null && tempB != null) {
            if(tempA == tempB) return tempA;
            tempA = tempA.next;
            tempB = tempB.next;
        }

        return null;
    }
}