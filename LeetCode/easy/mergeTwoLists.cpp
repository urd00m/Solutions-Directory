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
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        ListNode* newList;
        ListNode* head; 
        if(list1 != nullptr && list2 == nullptr) return list1;
        if(list2 != nullptr && list1 == nullptr) return list2;
        if(list1 == nullptr && list2 == nullptr) return nullptr;
        
        if(list1->val < list2->val) {
            newList = list1; 
            head = list1;
            list1 = list1->next; 
        }
        else { 
            newList = list2; 
            head = list2; 
            list2 = list2->next; 
        }
        
        while(list1 != nullptr || list2 != nullptr) {
            if(list2 == nullptr || (list1 != nullptr && list1->val < list2->val)) {
                newList->next = list1; 
                list1 = list1->next; 
                newList = newList->next;
            }
            else { 
                newList->next = list2; 
                list2 = list2->next; 
                newList = newList->next;
            }
        }
        newList->next = nullptr; // zero out lost element
        
        return head; 
    }
};
