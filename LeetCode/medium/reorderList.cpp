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
    void reorderList(ListNode* head) {
        
        //obtain split point
        int size = 0; 
        ListNode* curNode = head; 
        while(curNode) {
            size++; 
            curNode = curNode->next; 
        }
        int mid = (size%2==0 ? size/2 : (size/2) + 1); 
        
        //divide into 2 sections 
        vector<ListNode*> l; 
        vector<ListNode*> r; 
        int i = 0; 
        curNode = head; 
        while(i < mid) {
            l.push_back(curNode);
            curNode = curNode->next; 
            i++; 
        }
        while(i < size) {
            r.push_back(curNode);
            curNode = curNode->next;
            i++; 
        }
        reverse(r.begin(), r.end()); 
        
        //create new 
        long left = 0;
        long right = 0; 
        ListNode* prev = l[left++];
        ListNode* cur = nullptr; 
        bool isL = false; 
        for(int j = 1; j < size; j++) {
            if(isL == false) cur = r[right++]; 
            else cur = l[left++];
            isL = !isL; 
            prev->next = cur; 
            prev = cur;
            cur = nullptr; 
            prev->next = nullptr; 
        }
    }
};
