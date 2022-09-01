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
    int goodNodes(TreeNode* root) {
        int ret = 0; 
        if(root == nullptr) return 0; 
        
        //bfs 
        queue<TreeNode*> next_ptr; // stores {TreeNode* cur, maximum element on path} 
        queue<int> next_max_path; 
        next_ptr.push(root); next_max_path.push(root->val); 
        while(!next_ptr.empty()) {
            TreeNode* cur = next_ptr.front(); next_ptr.pop(); 
            int max_path = next_max_path.front(); next_max_path.pop(); 
            
            //base case 
            if(cur == nullptr) continue; 
            
            // update ret 
            if(cur->val >= max_path) {
                ret++; 
                max_path = cur->val; 
            }
            
            // go to children 
            next_ptr.push(cur->left); next_max_path.push(max_path);
            next_ptr.push(cur->right); next_max_path.push(max_path);
        }
        return ret; 
    }
    
};
