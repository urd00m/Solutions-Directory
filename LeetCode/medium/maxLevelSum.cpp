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
    int maxLevelSum(TreeNode* root) {
        // queue base 
        queue<TreeNode*>* cur; 
        queue<TreeNode*>* next = new queue<TreeNode*>(); next->push(root);

        // begin iteration
        int level_max = INT32_MIN;
        int ret = -1; 
        int level = 1; 
        while(!next->empty()) {
            cur = next; 
            next = new queue<TreeNode*>(); 
            int level_sum = 0; 
            while(!cur->empty()) {
                TreeNode* c = cur->front(); cur->pop(); 
                level_sum += c->val; 

                // add children to next
                if(c->left) next->push(c->left);
                if(c->right) next->push(c->right);
            }
            if(level_sum > level_max) {
                level_max = level_sum; 
                ret = level; 
            }
            level++; 
        }
        return ret; 
    }
};
