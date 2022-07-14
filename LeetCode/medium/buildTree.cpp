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
    // preorder is dfs -> root, left, right
    // in order is left, root, right 
    int preIdx; 
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        if(preorder.size() == 0) return nullptr; 
        
        // speedup 
        unordered_map<int, int> i;    // inorder val -> idx
        
        // init 
        for(long j = 0; j < preorder.size(); j++) 
            i[inorder[j]] = j; 
        
        // use recursion 
        preIdx = 0; 
        return recur(preorder, i, 0, preorder.size()-1); 
    }
    
    // recursion 
    TreeNode* recur(vector<int>& preorder, unordered_map<int, int>& i, int l, int r) {
        if(r < l) return nullptr; 
        
        TreeNode* curNode = new TreeNode(preorder[preIdx++]); 
        
        // follow preorder 
        curNode->left = recur(preorder, i, l, i[curNode->val]-1);
        curNode->right = recur(preorder, i,  i[curNode->val]+1, r);
            
        return curNode; 
    }
    
    
};
