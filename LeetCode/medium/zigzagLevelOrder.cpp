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
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        if(root == nullptr) return {}; 
        vector<vector<int>> ret; 
        bool left_to_right = true; 
        queue<TreeNode*> *level = new queue<TreeNode*>(); level->push(root); 
        queue<TreeNode*> *next_level = new queue<TreeNode*>(); 
        ret.push_back({}); 
        while(!level->empty()) {
            TreeNode* cur = level->front(); level->pop(); 

            // push onto stack 
            ret[ret.size()-1].push_back(cur->val); 

            // visit all in level 
            if(cur->left) next_level->push(cur->left);
            if(cur->right) next_level->push(cur->right); 

            // check if emtpy 
            if(level->empty()) {
                //flip ret if necessary 
                if(!left_to_right) reverse(ret[ret.size()-1].begin(), ret[ret.size()-1].end()); 
                
                // move levels over
                level = next_level; 
                next_level = new queue<TreeNode*>(); 
                left_to_right = !left_to_right; 

                // if we have room increase ret size
                if(!level->empty()) ret.push_back({}); 
            }
        }

        return ret; 
    }
};
