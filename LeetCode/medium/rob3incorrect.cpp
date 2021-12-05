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
    int rob(TreeNode* root) {
        //squash down based on depth 
        vector<int> nums; 
        vector<TreeNode*> level; 
        level.push_back(root); 
        while(level.size() > 0) {
            int sum = 0; 
            vector<TreeNode*> nextLevel; 
            for(TreeNode* node : level) {
                sum += node->val; 
                if(node->left != nullptr) nextLevel.push_back(node->left);
                if(node->right != nullptr) nextLevel.push_back(node->right);
            }
            nums.push_back(sum); 
            level = nextLevel; 
        }
        
        //dp either we except or we don't 
        vector<int> dp(nums.size()+2, 0);
        for(long i = 0; i < nums.size(); i++) {
            dp[i+2] = max(dp[i+2], dp[i] + nums[i]); 
            
            dp[i+1] = max(dp[i+1], dp[i]); 
        }
        
        return max(dp[nums.size()], dp[nums.size()+1]); 
    }
};

//incorrect solution to squash the binary tree baed on depth, since if different subtrees have different depth it doesn't make sense to do this since you ened to treat them as different trees
