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
    vector<int> rightSideView(TreeNode* root) {
        vector<int> ret; 
        dfs(ret, root, 0);
        return ret; 
    }
    
    void dfs(vector<int>& ret, TreeNode* cur, int depth) {
        if(cur == nullptr) return; 
        if(ret.size() <= depth)
            ret.push_back(cur->val); 
        ret[depth] = cur->val; 
        dfs(ret, cur->left, depth+1); //so right value overright left values 
        dfs(ret, cur->right, depth+1);
    }
};
