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
    vector<int> findMode(TreeNode* root) {
        unordered_map<int, int> m; 
        queue<TreeNode*> n; n.push(root); 
        while(!n.empty()) {
            TreeNode* cur = n.front(); n.pop(); 
            if(!cur) continue; 
            if(m.find(cur->val) == m.end()) m[cur->val] = 0; 
            m[cur->val]++; 
            n.push(cur->left);
            n.push(cur->right);
        }

        // find mode 
        vector<int> mode;
        int cnt = 0; 
        for(auto& [key, value] : m) {
            if(value > cnt) {
                mode = {key};
                cnt = value; 
            }
            else if(value == cnt)
                mode.push_back(key); 
        }   
        return mode; 
    }
};
