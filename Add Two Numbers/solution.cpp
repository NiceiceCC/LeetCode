/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode head ;
        auto pCur = &head;
        int carry;
        while (l1 or l2 or carry){
            int v1 = l1 == nullptr?0:l1->val;
            int v2 = l2 == nullptr?0:l2->val;
            int v = v1+v2+carry;
            carry = int(v/10);
            pCur->next = new ListNode(v-carry*10);
            pCur = pCur->next;
            l1 = l1 == nullptr? nullptr:l1->next;
            l2 = l2 == nullptr? nullptr:l2->next;
            cout<<pCur->val;
            
        }
        return head.next;
    }
};