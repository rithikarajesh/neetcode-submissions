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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
      //Find the middle node
        ListNode slow  = head;
        ListNode fast = head;
        while(fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse from slow.next

        ListNode prev = null;
        ListNode current = slow.next;
        slow.next = null;
        ListNode next;
        while(current!= null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        // head list 1 
        // prev list 2
        ListNode list1 = head.next;
        ListNode list2  = prev;
        current = head;


        while(list1 != null && list2 != null){
            current.next = list2;
            list2 = list2.next;
            current = current.next;
            current.next = list1;
            list1 = list1.next;
            current = current.next;
        } 

        current.next = list1!=null? list1 : list2;
    }
}