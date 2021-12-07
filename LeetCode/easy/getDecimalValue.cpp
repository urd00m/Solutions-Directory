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
    int getDecimalValue(ListNode* head) {
        string bin = "";
        ListNode* cur = head; 
        while(cur != nullptr) {
            bin += to_string(cur->val); 
            cur = cur->next; 
        }
        
        //convert to decimal 
        int decimal = 0; 
        int exp = bin.length()-1; 
        for(size_t i = 0; i < bin.length(); i++) {
            decimal += (bin[i]-'0')*(1<<exp--); 
        }
        
        return decimal; 
    }
};
