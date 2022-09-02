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
    vector<double> averageOfLevels(TreeNode* root) {
        //dfs 
        int max_depth_counter = 0; 
        vector<long> level_sum = vector<long>(1, 0); 
        vector<long> level_count = vector<long>(1, 0); 
        
        dfs(level_sum, level_count, max_depth_counter, 0, root); 
        
        // calculate averages 
        vector<double> ret; 
        for(int i = 0; i <= max_depth_counter; i++) {
            ret.push_back( (level_sum[i]*1.0)/(level_count[i]*1.0) ); 
        }
        return ret; 
    }
    
    void dfs(vector<long>& level_sum, vector<long>& level_count, int& max_depth_counter, int depth, TreeNode* cur) {
        if(cur == nullptr) return; 
        
        if(depth > max_depth_counter) {
            max_depth_counter++; 
            level_count.push_back(0); 
            level_sum.push_back(0); 
        }
        level_count[depth]++; 
        level_sum[depth] += cur->val; 
        
        dfs(level_sum, level_count, max_depth_counter, depth+1, cur->left);
        dfs(level_sum, level_count, max_depth_counter, depth+1, cur->right);
    }
};
