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
    int idx = 0;
    
    //recursive 
    /*
        You know that at any point you are technically still at tree, so at each point you treat yourself as a root. For the base that you are the root you are n. Then you travel to the left subtree, and if that subtree is greater than the root you end since you can't be greater than the root on the leftside. 
        
        the reason it works for the case breaking the incorrect solution is becasue it is important to notice when going right your limit is what it used to be where as you go left your limit is what your previous root was. So in the case of the case breaking the incorrect solution since you are above all the limits. Therefore it cycles back to the 10 and goes to the right of that. 
        
        another optimization that makes this solution work is by keeping idx static in a sense among the different recursive calls. And noticing that going left changes your limits and going right maintains the previous limits. 
    */
    TreeNode* bstFromPreorder(vector<int>& preorder, int p_val = INT_MAX) {
        if (idx >= preorder.size() || preorder[idx] > p_val)
            return nullptr;
        auto n = new TreeNode(preorder[idx++]);
        n->left = bstFromPreorder(preorder, n->val);
        n->right = bstFromPreorder(preorder, p_val);
        return n;
    }
};
