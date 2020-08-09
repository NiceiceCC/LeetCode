# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        head = ListNode()
        cur = head
        carry = 0
        while l1 or l2 or carry>0:
            val1 = 0 if not l1 else l1.val
            val2 = 0 if not l2 else l2.val
            val = val1 + val2 + carry
            carry = val//10
            val = val - carry*10
            cur.next = ListNode(val)
            l1 = None if not l1 else l1.next
            l2 = None if not l2 else l2.next
            cur = cur.next
        return head.next