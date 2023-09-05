/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;
    
    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};
*/

class Solution {
public:
    Node* recur(Node* cur, unordered_map<Node*, Node*>& m) {
        if(cur == nullptr) return nullptr; 
        if(m.find(cur) != m.end()) return m[cur]; 
        
        // begin copy 
        Node* ret = new Node(cur->val); 
        m[cur] = ret; 

        // copy next
        if(cur->next) ret->next = recur(cur->next, m);
        if(cur->random) ret->random = recur(cur->random, m);
        return ret; 
    }

    Node* copyRandomList(Node* head) {
        if(head == nullptr) return nullptr; 

        // begin copying 
        unordered_map<Node*, Node*> m; 
        return recur(head, m); 
    }
};
