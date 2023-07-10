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
    int recur(TreeNode* cur, int d) {
        if(!cur->left && !cur->right) return d; 
        else {
            int ret = INT32_MAX;
            if(cur->left) ret = min(ret, recur(cur->left, d+1)); 
            if(cur->right) ret = min(ret, recur(cur->right, d+1)); 
            return ret; 
        }   
    }

    int minDepth(TreeNode* root) {
        if(!root) return 0;
        return recur(root, 1);
    }
};
