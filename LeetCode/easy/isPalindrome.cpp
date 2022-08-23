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
    bool isPalindrome(ListNode* head) {
        // convert to vector
        vector<int> ary; 
        ListNode* next = head; 
        while(next) {
            ary.push_back(next->val);
            next = next->next; 
        }
        
        // is palindrome 
        int l = 0; 
        int r = ary.size()-1; 
        while(l < r) {
            if(ary[l] != ary[r]) return false; 
            l++; r--; 
        }
        return true; 
    }
};
