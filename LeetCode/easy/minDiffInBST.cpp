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
    int minDiffInBST(TreeNode* root) {
        // collect nodes 
        vector<int> val; 
        queue<TreeNode*> n; n.push(root); 
        while(!n.empty()) {
            TreeNode* cur = n.front(); n.pop(); 
            if(!cur) continue; 
            val.push_back(cur->val);
            n.push(cur->left);
            n.push(cur->right);
        }
        sort(val.begin(), val.end()); 
        int ret = INT32_MAX; 
        for(int i = 1; i < val.size(); i++) ret = min(ret, val[i]-val[i-1]); 
        return ret; 
    }
};
