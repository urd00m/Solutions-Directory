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
    vector<vector<int>> levelOrder(TreeNode* root) {
        if(root == nullptr) return {}; 
        vector<TreeNode*> curLevel;
        vector<TreeNode*> nextLevel;
        curLevel.push_back(root); 
        vector<vector<int>> ret; 
        while(curLevel.size() > 0) {
            vector<int> level; 
            for(TreeNode* cur : curLevel) {
                if(!cur) continue; 
                level.push_back(cur->val);
                if(cur->left) nextLevel.push_back(cur->left);
                if(cur->right) nextLevel.push_back(cur->right); 
            }
            curLevel = nextLevel; 
            nextLevel = vector(0, (TreeNode*)nullptr); 
            ret.push_back(level); 
        }
        return ret; 
    }
};
