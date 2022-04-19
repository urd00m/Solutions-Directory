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
    TreeNode* first, *second, *prev; 
    void recoverTree(TreeNode* root) {
        prev = new TreeNode(INT32_MIN); 
        dfs(root); 
        int temp = first->val;
        first->val = second->val; 
        second->val = temp; 
    }
    
    void dfs(TreeNode* curNode) {
        if(curNode == nullptr) return; 
        
        dfs(curNode->left);
        if(first == nullptr && curNode->val < prev->val) {
            first = prev; 
        }
        if(first != nullptr && curNode->val < prev->val) {
            second = curNode; 
        }
        prev = curNode; 
        
        dfs(curNode->right);
    }
};
