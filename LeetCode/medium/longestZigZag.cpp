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
 #define LEFT 0
 #define RIGHT 1

class Solution {
public:
    int ret; 
    vector<int> recur(TreeNode* cur) {
        if(!cur) return {0, 0}; 

        // visit left 
        int l = recur(cur->left)[RIGHT] + 1; 
        int r = recur(cur->right)[LEFT] + 1; 

        // max
        Solution::ret = max(Solution::ret, l);
        Solution::ret = max(Solution::ret, r);

        // return 
        return {l, r}; 
    }

    int longestZigZag(TreeNode* root) {
        // store left right for each node 
        Solution::ret = 0; 
        recur(root);
        return Solution::ret - 1; 
    }
};

// kind of a lot of overhead 
// faster ways of doing this but I'm lazy 
