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
    ListNode* deleteMiddle(ListNode* head) {
        // determine size and middle position 
        ListNode* cur = head; 
        long n = 0; 
        while(cur) {
            n++; 
            cur = cur->next; 
        }
        
        if(n == 1) return nullptr; 
        long mid = n/2; 
        cur = head; 
        for(int i = 0; i < mid-1; i++) {
            cur = cur->next; 
        }
        cur->next = cur->next->next; 
        return head; 
    }
};
