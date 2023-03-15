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
    bool isCompleteTree(TreeNode* root) {
        // bfs 
        queue<TreeNode*> curLevel, nextLevel; 
        nextLevel.push(root); 
        bool next_is_last_level = false, this_is_last_level = false; 

        // bfs level by level 
        while(!nextLevel.empty()) {
            curLevel = nextLevel; 
            nextLevel = queue<TreeNode*>(); 
            while(!curLevel.empty()) {
                TreeNode* cur = curLevel.front(); curLevel.pop(); 

                // last level 
                if(this_is_last_level) {
                    if(cur->left || cur->right) return false;
                    continue; 
                }

                // middle level 
                if(!next_is_last_level && cur->left && cur->right) {
                    nextLevel.push(cur->left);
                    nextLevel.push(cur->right);
                }
                else { // next is last level 
                    if(next_is_last_level && (cur->left || cur->right)) return false; 
                    next_is_last_level = true; 
                    if(cur->left) nextLevel.push(cur->left);
                    if(cur->right) return false; 
                }
            } 
            if(next_is_last_level) this_is_last_level = true; 
        }
        return true; 
    }
};
// wayyyyyyy overcomplicated literally BFS handles level by level
