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
    ListNode* middleNode(ListNode* head) {
        int size = 0;
        ListNode* curNode = head; 
        while(curNode != nullptr) {
            size++; 
            curNode = curNode->next; 
        }
        int mid = size/2 + 1; 
        curNode = head; 
        for(int i = 0; i < mid-1; i++) {
            curNode = curNode->next; 
        }
        return curNode; 
    }
};
