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
    vector<ListNode*> ary; 
    Solution(ListNode* head) {
        ListNode* cur = head; 
        while(cur)  {
            ary.push_back(cur); 
            cur = cur->next;    
        }
    }
    
    int getRandom() {
        random_device random_dev;
        mt19937       generator(random_dev());
        shuffle(ary.begin(), ary.end(), generator);
        return ary[0]->val; 
    }
};

/**
 * Your Solution object will be instantiated and called as such:
 * Solution* obj = new Solution(head);
 * int param_1 = obj->getRandom();
 */x
