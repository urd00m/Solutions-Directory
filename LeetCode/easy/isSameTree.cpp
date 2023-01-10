/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    bool isSameTree(TreeNode* p, TreeNode* q) {
        if(p == nullptr && q == nullptr) return true; 
        if(p == nullptr || q == nullptr) return false; 
        
        // bfs 
        queue<TreeNode*> nextp, nextq; 
        nextp.push(p); 
        nextq.push(q); 
        while(!nextp.empty()) { 
            TreeNode* curp = nextp.front(); nextp.pop(); 
            TreeNode* curq = nextq.front(); nextq.pop(); 
            
            // value check
            if(curp->val != curq->val) return false; 

            // add children 
            if(curp->left && curq->left) {
                nextp.push(curp->left); 
       ~/*      nextq.push(curq->left);
            }
            else if( !(curp->left == nullptr && curq->left == nullptr) ) return false; 
            if(curp->right && curq->right) {
                nextp.push(curp->right);
                nextq.push(curq->right);
            }
            else if( !(curp->right == nullptr && curq->right == nullptr) ) return false; 
        }
        return true; 
    }
};
