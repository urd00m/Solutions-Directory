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
    ListNode* oddEvenList(ListNode* head) {

        // count size of linked list
        ListNode *cur = head; 
        int size = 0; 
        while(cur) {size++; cur = cur->next;}

        if(size <= 2) return head; 

        // do swap 
        ListNode *last_even; 
        ListNode *first_odd; 
        cur = head;
        for(int i = 0; i < size-1; i++) {
            if(i == 1) first_odd = cur; 
            if(i%2 == 0) last_even = cur; 
            ListNode *next = cur->next; 
            cur->next = cur->next->next;
            cur = next; 
        }
        if(size%2 == 1) last_even = cur; 
        last_even->next = first_odd; 

        return head; 
    }
};
