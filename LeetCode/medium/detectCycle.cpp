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
    ListNode *detectCycle(ListNode *head) {
        unordered_map<ListNode*, int> nodeToIndex; 
        
        ListNode* curNode = head; 
        int index = 0; 
        while(curNode) {
            if(nodeToIndex.find(curNode) == nodeToIndex.end()) { //not found 
                nodeToIndex[curNode] = index; 
            }
            else {
                return curNode; //cycle found 
            }
            index++; 
            curNode = curNode->next; 
        }
        return nullptr; //no cycle 
    }
};

//took 5 minutes 
