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

    int dfs(TreeNode* cur, vector<int>& anc) {
        if(!cur) return 0; 

        // backtracking measurements
        int ret = 0; 
        for(int val : anc) 
            ret = max(ret, (int)abs(val - cur->val)); 

        // backtracking 
        anc.push_back(cur->val);
        ret = max(ret, dfs(cur->left, anc)); 
        ret = max(ret, dfs(cur->right, anc)); 
        anc.pop_back(); 

        return ret; 
    }

    int maxAncestorDiff(TreeNode* root) {
        // O(n log n)
        // you only have log n ancestors, you can compare with all of them 
        // recursive backtracking 
        vector<int> anc; 
        return dfs(root, anc); 
    }
};
