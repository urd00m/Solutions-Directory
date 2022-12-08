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

    void dfs(TreeNode* cur, vector<int>& ret) {
        if(!cur) return; 

        // traverse 
        if(!cur->left && !cur->right) ret.push_back(cur->val);

        dfs(cur->left, ret);
        dfs(cur->right, ret); 
    }

    bool leafSimilar(TreeNode* root1, TreeNode* root2) {
        // traverse to each leaf 
        vector<int> value1, value2; 

        dfs(root1, value1); 
        dfs(root2, value2); 

        if(value1.size() != value2.size()) return false; 

        for(int i = 0; i < value1.size(); i++) 
            if(value1[i] != value2[i]) return false;

        return true; 
    }
};
