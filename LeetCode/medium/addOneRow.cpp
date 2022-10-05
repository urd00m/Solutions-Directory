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
    TreeNode* addOneRow(TreeNode* root, int val, int depth) {
        
        if(depth == 1) {
            TreeNode* ret = new TreeNode(val, root, nullptr);
            return ret; 
        }
        
        // bfs to depth 
        queue<TreeNode*> next; 
        queue<TreeNode*> delta; 
        int curDepth = 1; 
        next.push(root); 
        while(curDepth < depth-1) {
            while(!next.empty()) {
                TreeNode* cur = next.front(); next.pop(); 
                if(cur) {
                    delta.push(cur->left); delta.push(cur->right); 
                }
            }
            next = delta; 
            delta = queue<TreeNode*>(); 
            curDepth++; 
        }
        
        // insert at depth 
        while(!next.empty()) {
            TreeNode *cur = next.front(); next.pop(); 
            if(cur) {
                cur->left = new TreeNode(val, cur->left, nullptr); 
                cur->right = new TreeNode(val, nullptr, cur->right);
            }
        }
        return root; 
    }
};
