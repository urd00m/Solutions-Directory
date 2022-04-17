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
    vector<TreeNode*> inorder; 
    TreeNode* increasingBST(TreeNode* root) {
        //dfs 
        dfs(root);
        
        for(long i = 0; i < inorder.size()-1; i++) {
            inorder[i]->left = nullptr; 
            inorder[i]->right = inorder[i+1]; 
        }
        inorder[inorder.size()-1]->left = nullptr;
        inorder[inorder.size()-1]->right = nullptr;
        return inorder[0];
    }
    void dfs(TreeNode* cur) {
        if( cur->left == nullptr && cur->right == nullptr) {
            Solution::inorder.push_back(cur); 
        }
        else {
            if(cur->left != nullptr) dfs(cur->left);
            Solution::inorder.push_back(cur);
            if(cur->right != nullptr) dfs(cur->right); 
        }
    }
};
