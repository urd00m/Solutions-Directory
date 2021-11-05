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
    ListNode* partition(ListNode* head, int x) {
        vector<int> left; 
        vector<int> right; 
        
        //find 
        ListNode* cur = head; 
        while(cur != nullptr) {
            if(cur->val < x) left.push_back(cur->val);
            else right.push_back(cur->val); 
            cur = cur->next; 
        }
        
        //create new 
        ListNode* root = nullptr;
        cur = nullptr; 
        for(long i = 0; i < left.size(); i++) {
            if(root == nullptr) {
                root = new ListNode(left[i]);
                cur = root; 
            }
            else {
                cur->next = new ListNode(left[i]); 
                cur = cur->next; 
            }
        }
        for(long i = 0; i < right.size(); i++) {
            if(root == nullptr) {
                root = new ListNode(right[i]);
                cur = root; 
            }
            else {
                cur->next = new ListNode(right[i]); 
                cur = cur->next; 
            } 
        }
        
        return root; 
    }
};

//< 5 mins
