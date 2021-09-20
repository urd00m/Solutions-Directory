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
        ListNode* curl = l1; 
        ListNode* curr = l2; 
        int overflow = 0;
        ListNode* head = new ListNode(); 
        ListNode* ret = head; 
        while(curl != nullptr || curr != nullptr) {
            //ret->val = overflow; 
            if(curl != nullptr) {
                ret->val += curl->val;
            }
            if(curr != nullptr) {
                ret->val += curr->val; 
            }
            if(ret->val >= 10) {
                ret->val %= 10; 
                overflow = 1; 
            }
            else {
                overflow = 0; 
            }
            if(curr!=nullptr) curr = curr->next;
            if(curl!=nullptr) curl = curl->next; 
            if(curr != nullptr || curl != nullptr || overflow == 1) {
                ret->next = new ListNode(overflow); 
                ret = ret->next; 
            }
        }
        return head; 
    }
};
