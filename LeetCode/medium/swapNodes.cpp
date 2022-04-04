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
#include <algorithm>

class Solution {
public:
    ListNode* swapNodes(ListNode* head, int k) {
        k = k-1; // 0 index 
        // We need length 
        ListNode* cur = head; 
        long n = 0; 
        while(cur != nullptr) {
            n++; 
            cur = cur->next; 
        }
        
        // We need the 2 nodes and and the 2 nodes around them 
        if(abs(k-1 - (n-k-2)) == 0) {
            return head; // do nothing 
        } else if(n == 2) {
            ListNode* temp = head; 
            head = head->next;
            head->next = temp; 
            temp->next = nullptr;
            return head; 
        }
        else if(k == 0 || k == n-1) {
            // Swap head with end 
            ListNode* headOld = head; 
            ListNode* headNext = head->next; 
            ListNode* endPrev = head;
            for(long i = 1; i < n-1; i++) {
                endPrev = endPrev->next; 
            }
            ListNode* endOld = endPrev->next;

            // swap 
            head = endOld; 
            head->next = headNext; 
            endPrev->next = headOld; 
            headOld->next = nullptr; 
            
            return head; 
        }  
        else if( abs(k-1 - (n-k-2)) == 1) {
            ListNode* prev = head; 
            for(long i = 0; i < std::min<long>(k-1, (n-k-2)); i++) {
                prev = prev->next; 
            }
            ListNode* left = prev->next;
            ListNode* right = left->next; 
            ListNode* next = right->next; 

            left->next = next;
            right->next = left; 
            prev->next = right; 
            return head; 
        }
        else { 
            //  Get K 
            ListNode* firstPrev = head; 
            for(long i = 0; i < k-1; i++) {
                firstPrev = firstPrev->next; 
            }
            ListNode* firstOld = firstPrev->next; 
            ListNode* firstNext = firstOld->next; 
            
            ListNode* secondPrev = head; 
            for(long i = 0; i < n-k-2; i++) {
                secondPrev = secondPrev->next; 
            }
            ListNode* secondOld = secondPrev->next; 
            ListNode* secondNext = secondOld->next;
            
            // swap 
            firstPrev->next = secondOld; 
            secondOld->next = firstNext; 
            secondPrev->next = firstOld; 
            firstOld->next = secondNext; 
            return head; 
        }
    }
};
