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
    void recur(TreeNode* cur, vector<int>& ret) {
        if(!cur) return; 

        ret.push_back(cur->val);
        recur(cur->left, ret);
        recur(cur->right, ret);
    }

    vector<int> preorderTraversal(TreeNode* root) {
        // preorder is classic dfs 
        vector<int> ret; 
        recur(root, ret);
        return ret; 
    }
};
