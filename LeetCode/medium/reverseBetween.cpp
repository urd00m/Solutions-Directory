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
    ListNode* reverseBetween(ListNode* head, int left, int right) {
        ListNode* curNode = head; 
        
        ListNode* newHead = nullptr; 
        ListNode* start = nullptr; 
        ListNode* reverseHead = nullptr;
        ListNode* reverse = nullptr;
        ListNode* endHead = nullptr; 
        ListNode* end = nullptr; 
        
        //navigate to start of reverse 
        int counter = 0; 
        while(curNode) { //start 
            if(++counter == left) break; 
            if(newHead == nullptr) {
                newHead = curNode;
                start = curNode;
            }
            else {
                start->next = curNode; 
                start = start->next; 
            }
            
            curNode = curNode->next; 
        }
        while(curNode) { //reverse portion 
            if(counter == right+1) break; 
            if(reverse == nullptr) {
                reverse = curNode; 
                reverseHead = curNode; 
            }
            else {
                reverse->next = curNode; 
                reverse = reverse->next; 
            }
            
            curNode = curNode->next; 
            counter++; 
        }
        while(curNode) { //end portion 
            if(end == nullptr) {
                end = curNode; 
                endHead = curNode; 
            }
            else {
                end->next = curNode;
                end = end->next; 
            }
            curNode = curNode->next; 
        }
    
        //reverse the portion 
        ListNode* reverseNewHead = nullptr; 
        ListNode* reverseNew = nullptr; 
        for(long i = right-left; i >= 0; i--) {
            long num = i+1; 
            curNode = reverseHead; 
            while(--num != 0) {
                curNode = curNode->next; 
            }
            if(reverseNew == nullptr) {
                reverseNew = curNode; 
                reverseNewHead = curNode; 
            }
            else {
                reverseNew->next = curNode; 
                reverseNew = reverseNew->next;  
            }
        }
                
        //link together
        if(start != nullptr) start->next = reverseNewHead; 
        else {
            newHead = reverseNewHead; 
        }
        if(endHead != nullptr) reverseNew->next = endHead;
        else reverseNew->next = nullptr; 
        return newHead;
        
    }
};
