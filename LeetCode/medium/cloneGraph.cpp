/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> neighbors;
    Node() {
        val = 0;
        neighbors = vector<Node*>();
    }
    Node(int _val) {
        val = _val;
        neighbors = vector<Node*>();
    }
    Node(int _val, vector<Node*> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/

class Solution {
public:
    vector<bool> visited; // Mark them all as not visited 
    vector<Node*> ourNode; // Store our copy nodes 
    Node* cloneGraph(Node* node) {
        if(node == nullptr) return nullptr; 
        
        Solution::visited = vector(101, false);
        for(int i = 0; i < 102; i++) Solution::ourNode.push_back(nullptr); 
        
        Node* ret = new Node(node->val);

        visited[ret->val] = true; 
        ourNode[ret->val] = ret; 
        for(Node* next : node->neighbors) {
            if(visited[next->val] == true) {
                ret->neighbors.push_back(ourNode[next->val]); 
            }
            else {
                recur(ret, next); 
            } 
        }
        
        return ret; 
    }
    
    // parent is deep copy, cur is other
    void recur(Node* par, Node* cur) {
        if(Solution::visited[cur->val] == true) { //already visited 
            return; //exit 
        } 
        
        Node* newNode = new Node(cur->val); 
        Solution::ourNode[cur->val] = newNode; 
        Solution::visited[cur->val] = true; 
//        newNode->neighbors.push_back(par); 
        par->neighbors.push_back(newNode); 
        for(Node* next : cur->neighbors) {
            if(visited[next->val] == true) {
                newNode->neighbors.push_back(ourNode[next->val]); 
            }
            else {
                recur(newNode, next); 
            }
        }
        
    }
};
