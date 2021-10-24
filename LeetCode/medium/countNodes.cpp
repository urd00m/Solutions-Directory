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
    int countNodes(TreeNode* root) {
        //recursion 
        return recur(root); 
    }
    
    int recur(TreeNode* cur) {
        if(cur == nullptr) return 0; 
        
        //calculate heights
        int hl = 1;
        int hr = 1;
        TreeNode* l = cur->left;
        TreeNode* r = cur->right; 
        while(l) { l = l->left; hl++; }
        while(r) { r = r->right; hr++; }
        
        if(hl == hr) return pow(2, hl)-1;
        else return 1 + recur(cur->left) + recur(cur->right); 
    }
};
