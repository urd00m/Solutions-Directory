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
    vector<string> nums; 
    int sumNumbers(TreeNode* root) {
        recur(root, "");
        
        int sum = 0;
        for(string item : nums) {
            sum += stoi(item);
        }
        
        return sum; 
    }
    
    void recur(TreeNode* cur, string s) {
        if(cur->left == nullptr && cur->right == nullptr) nums.push_back(s + to_string(cur->val)); 
        
        s = s+to_string(cur->val); 
        if(cur->left != nullptr) recur(cur->left, s);
        if(cur->right != nullptr) recur(cur->right, s);
    }
};
