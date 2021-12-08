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
    int ret;
    int findTilt(TreeNode* root) {
        Solution::ret = 0; 
        recur(root); 
        return Solution::ret; 
    }
    
    int recur(TreeNode* cur) {
        if(cur == nullptr) return 0; 
        if(cur->left == nullptr && cur->right == nullptr) return cur->val; 
        int left = 0;
        if(cur->left != nullptr) left = recur(cur->left);
        int right = 0; 
        if(cur->right != nullptr) right = recur(cur->right);
        Solution::ret += abs(left-right); 
        return left+right+cur->val; 
    }
};
