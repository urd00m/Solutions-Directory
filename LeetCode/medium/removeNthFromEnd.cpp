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
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        //Get the size 
        ListNode* cur = head; 
        int size = 0; 
        while(cur != nullptr) {
            size++; 
            cur = cur->next; 
        }
        
        // Navigate to that element - 1
        cur = head;
        //if we are removing the head
        if(size-n == 0) {
            return cur->next; 
        }
        for(int i = 0; i < size-n-1; i++) {
            cur = cur->next; 
        }
        
        cur->next = cur->next->next; 
        return head; 
    }
};
