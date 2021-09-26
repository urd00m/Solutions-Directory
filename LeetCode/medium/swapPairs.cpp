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
    ListNode* swapPairs(ListNode* head) {
        //Find every two
        ListNode* ret; //set to the head of the new item 
        if(head == nullptr) return nullptr; 
        ListNode* cur1 = head;  
        ListNode* cur2 = head->next; 
        if(cur2 == nullptr) return cur1; 
        cur1->next = cur2->next; 
        cur2->next = cur1; 
        ret = cur2; 
        
        ListNode* cur = cur1; 
        while(cur->next != nullptr && cur->next->next != nullptr) {
            cur2 = cur->next->next; 
            cur1 = cur->next; 
            cout << cur2->val << " " << cur1->val << endl; 
            cout << cur1->next->val << endl;
            cur1->next = cur2->next; 
            cur2->next = cur1; 
            cur->next = cur2;
            cur = cur1; 
        }
        
        return ret; 
    }
};
