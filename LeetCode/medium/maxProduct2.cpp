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

#define MOD 1000000007L

class Solution {
public:
    int dfs1(TreeNode* cur) {
        if(!cur) return 0; 

        cur->val += dfs1(cur->left) + dfs1(cur->right);
        return cur->val; 
    }

    long dfs2(TreeNode* cur, TreeNode* par) {
        if(!cur || !par) return 0L; 

        // find sum 
        long product = ((long)par->val - cur->val) * (long)cur->val; 

        product = max(product, dfs2(cur->left, par)); 
        product = max(product, dfs2(cur->right, par)); 
        return product; 
    }

    int maxProduct(TreeNode* root) {
        // first DFS to modify sums 
        dfs1(root);
        return (int)(dfs2(root, root) % MOD);
    }
};
