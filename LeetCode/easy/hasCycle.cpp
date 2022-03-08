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
    bool hasCycle(ListNode *head) {
        ListNode* cycle = new ListNode(-10001); //if it points to this node it is a cycle 
        
        ListNode* cur = head; 
        while(cur != nullptr) {
            if(cur->next == cycle) return true; // cycle 
            ListNode* temp = cur; 
            cur = cur->next; 
            temp->next = cycle; 
        }
        
        return false; //no cycle 
    }
};
