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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode cur = head;
        int carry = 0;
        while(l1 != null || l2 != null || carry>0 ){
            int v1 = l1==null?0:l1.val;
            int v2 = l2==null?0:l2.val;
            int v = v1+v2+carry;
            if (v>=10){
                carry = 1;
                cur.next = new ListNode(v-10);
            }
            else{
                cur.next = new ListNode(v);
                carry = 0;
            }
            cur = cur.next;
            if(l1!=null) l1 = l1.next;
            if(l2!=null) l2 = l2.next;
                
        }
        return head.next;
    }
}