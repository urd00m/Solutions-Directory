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
    vector<vector<int>> solution; 
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        solution.clear(); 
        if(root == nullptr) return {}; 
        vector<int> temp = {}; 
        recur(root, targetSum, temp);
        return Solution::solution; 
    }
    
    
    void recur(TreeNode* cur, int targetSum, vector<int>& back) {
        if(cur == nullptr && targetSum == 0) {
            Solution::solution.push_back(back);
            return;
        }
        else if(cur == nullptr) return;         
        back.push_back(cur->val); 
        if(cur->left != nullptr) recur(cur->left, targetSum-cur->val, back);
        if(cur->right != nullptr) recur(cur->right, targetSum-cur->val, back);
        if(cur->left == nullptr && cur->right == nullptr) recur(cur->right, targetSum-cur->val, back);
        back.pop_back(); 
    }
};
