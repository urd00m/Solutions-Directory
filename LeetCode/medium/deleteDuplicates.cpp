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
    ListNode* deleteDuplicates(ListNode* head) {
        int bucket[300]{0}; //offset = 100 
        
        //iterate 
        const long offset = 100;
        ListNode* cur = head; 
        while(cur != nullptr) {
            bucket[cur->val+offset]++; 
            cur = cur->next; 
        }
        
        //create new 
        ListNode* ret = nullptr; 
        cur = nullptr;
        for(long i = 0; i < 300; i++) {
            if(bucket[i] == 1) {
                if(ret == nullptr) {
                    ret = new ListNode(i-offset); 
                    cur = ret; 
                } 
                else {
                    cur->next = new ListNode(i-offset); 
                    cur = cur->next; 
                }
            }
        }
        
        return ret; 
    }
};

//< 5 mins
