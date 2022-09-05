/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val) {
        val = _val;
    }

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
public:
    vector<vector<int>> levelOrder(Node* root) {
        if(!root) return {}; 
        // bfs 
        queue<Node*> next, cur; 
        vector<vector<int>> ret; 
        next.push(root); 
        
        while(!next.empty()) {
            cur = next;
            next = queue<Node *>();
            vector<int> temp; 
            while(!cur.empty()) {
                Node* curNode = cur.front(); cur.pop(); 
                temp.push_back(curNode->val); 
                for(Node* nextNode : curNode->children) 
                    if(nextNode) next.push(nextNode); 
            }
            ret.push_back(temp);
        }
        
        return ret; 
    }
};
