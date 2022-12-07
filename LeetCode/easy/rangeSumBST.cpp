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
    int rangeSumBST(TreeNode* root, int low, int high) {
        // more optimized approaches but this is the simpliest, collapse tree then iterate 
        vector<int> vals;
        queue<TreeNode*> next; 
        next.push(root);
        while(!next.empty()) {
            TreeNode *cur = next.front(); next.pop(); 
            vals.push_back(cur->val);
            if(cur->left) next.push(cur->left);
            if(cur->right) next.push(cur->right);
        }

        // iterate
        int ret = 0;
        for(int val : vals) {
            if(low <= val && val <= high) ret += val;
        }
        return ret; 
    }
};
