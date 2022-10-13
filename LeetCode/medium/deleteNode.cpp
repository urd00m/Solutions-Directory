/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    void deleteNode(ListNode* node) {
        ListNode* cur = node; 
        while(cur->next->next) {
            cur->val = cur->next->val; 
            cur = cur->next; 
        }
        cur->val = cur->next->val; 
        cur->next = nullptr; 
    }
};
