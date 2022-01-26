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
    vector<int> getAllElements(TreeNode* root1, TreeNode* root2) {
        vector<int> ret; 
        
        queue<TreeNode*> next; 
        if(root1) next.push(root1); 
        while(next.empty() == false) {
            TreeNode* cur = nullptr;
            cur = next.front();   
            next.pop();
            ret.push_back(cur->val);
            if(cur->left) next.push(cur->left);
            if(cur->right) next.push(cur->right);
        }
        
        if(root2) next.push(root2); 
        while(next.empty() == false) {
            TreeNode* cur = nullptr;
            cur = next.front();   
            next.pop();
            ret.push_back(cur->val);
            if(cur->left) next.push(cur->left);
            if(cur->right) next.push(cur->right);
        }
        
        sort(ret.begin(), ret.end());
        
        return ret; 
    }
};
