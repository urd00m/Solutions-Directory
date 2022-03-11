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
    ListNode* rotateRight(ListNode* head, int k) {
        // take mod to get true value 
        // get that amount off the end 
        // disconnect and push new ones to the stack and reconnect 
        
        // edge case k = len (do nothing) 
        
        //get length 
        int n = 0; 
        ListNode* cur = head; 
        while(cur != nullptr) {
            n++; 
            cur = cur->next; 
        }
        
        // get modded version
        if(head == nullptr || k == 0) return head; 
        k = k % n;
        if(k == 0) return head; //edge case 
        
        // disconnect 
        int cnt = 0; 
        cur = head; 
        ListNode* next = nullptr; 
        while(true) {
            cnt++;
            if(cnt == (n-k)) {
                next = cur->next; 
                cur->next = nullptr;
                break; 
            }
            cur = cur->next; 
        }
        
        //push to stack 
        stack<ListNode*> connections; 
        while(next != nullptr) {
            connections.push(next); 
            next = next->next; 
        }
        
        // reconnnect
        ListNode* ret; 
        ListNode* prev = head; 
        while(connections.empty() == false) {
            cur = connections.top(); connections.pop();
            cur->next = prev; 
            prev = cur; 
        }
        return prev; 
    }
};
