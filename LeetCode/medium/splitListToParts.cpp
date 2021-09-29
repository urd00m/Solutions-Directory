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
    vector<ListNode*> splitListToParts(ListNode* head, int k) {
        vector<ListNode*> ret(k, nullptr); 
        vector<ListNode*> nexts(k, nullptr);   
        
        //need counts 
        ListNode* cur = head;
        int length  = 0;
        while(cur != nullptr)  {
            length++; 
            cur = cur->next; 
        }
        vector<int> counts(k, length/k); 
        for(int i = 0; i < length%k; i++) {
            counts[i]++; //add 1 extra to these 
        }

        //distrubution
        int turn = 0; 
        cur = head; 
        while(cur != nullptr) {
            if(counts[turn] == 0) {
                turn++; 
                continue; 
            }
            else {
                counts[turn]--; 
            }

            ListNode* cur_dup = new ListNode{cur->val};
            //cur_dup->next = nullptr; 
            //cur_dup->val = cur->val; 
            if(ret[turn] == nullptr) {
                ret[turn] = cur_dup; 
                nexts[turn] = cur_dup; 
            }
            else {
                nexts[turn]->next = cur_dup; 
                nexts[turn] = cur_dup; 
            }
            
            cur = cur->next; 
        }
        return ret; 
    }
};
