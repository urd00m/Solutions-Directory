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
    vector<TreeNode*> save; 
    void flatten(TreeNode* root) {
        save.clear();
        dfs(root); 
        if(save.size() == 0) return; 
        // reassemble O(n) extra space 
        for(long i = 1; i < save.size(); i++) {
            save[i-1]->left = nullptr;
            save[i-1]->right = save[i]; 
        }
        save[save.size()-1]->left = nullptr;
        save[save.size()-1]->right = nullptr;
    }
    
    void dfs(TreeNode* cur) {
        if(cur == nullptr) return; 
        Solution::save.push_back(cur); 
        dfs(cur->left);
        dfs(cur->right); 
    }
};
