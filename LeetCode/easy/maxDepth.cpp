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
    int maxDepth(TreeNode* root) {
        recur(root, 0);
        return Solution::ret; 
    }
    
    void recur(TreeNode* cur, int depth) {
        if(cur == nullptr) Solution::ret = max(depth, Solution::ret);
        else {
            recur(cur->left, depth+1);
            recur(cur->right, depth+1);
        }
    }
};
