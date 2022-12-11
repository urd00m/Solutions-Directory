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
    int dfs1(TreeNode* cur, unordered_map<TreeNode*, int>& path_max) {
        if(!cur) return 0; 

        // traverse
        int left = dfs1(cur->left, path_max); 
        int right = dfs1(cur->right, path_max); 

        // determine max path 
        int m = max(cur->val, max(cur->val+left, cur->val+right));
        path_max[cur] = m; 
        return m;  
    }

    int dfs2(TreeNode* cur, unordered_map<TreeNode*, int>& path_max) {
        if(!cur) return -1000000000; 

        // calculate current max 
        int m = cur->val; 
        if(cur->left && path_max[cur->left] > 0) m += path_max[cur->left];
        if(cur->right && path_max[cur->right] > 0 ) m += path_max[cur->right];

        // children max 
        m = max(m, dfs2(cur->left, path_max)); 
        m = max(m, dfs2(cur->right, path_max)); 
        return m; 
    }

    int maxPathSum(TreeNode* root) {
        // one dfs to find the maximum path for each node store in val 
        unordered_map<TreeNode*, int> path_max; 
        dfs1(root, path_max); 

        // second dfs to find the maximum path using two of the previous paths
        return dfs2(root, path_max); 
    }
};
