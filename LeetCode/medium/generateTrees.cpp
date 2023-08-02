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
    vector<TreeNode*> recur(int l, int r) {
        if(l > r) return {nullptr}; 

        // begin recur 
        vector<TreeNode*> ret;
        for(int i = l; i <= r; i++) {
            // create node at this point 
            vector<TreeNode*> left = recur(l, i-1); 
            vector<TreeNode*> right = recur(i+1, r); 
            for(TreeNode* tl : left) 
                for(TreeNode* tr : right) 
                    ret.push_back( new TreeNode(i, tl, tr) );
        }
        return ret; 
    }

    vector<TreeNode*> generateTrees(int n) {
        // recursion 
        return recur(1, n); 
    }
};
