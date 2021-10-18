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
    vector<int> parent; 
    bool isCousins(TreeNode* root, int x, int y) {
        int xdep = dfs(root, 0, x, -1);
        int ydep = dfs(root, 0, y, -1);
        if(xdep == ydep && Solution::parent.size() == 2 && Solution::parent[0] != Solution::parent[1]) return true;
        return false; 
    }
    
    int dfs(TreeNode* cur, int depth, int search, int par) {
       //base case 
        if(cur == nullptr) return -1; 
        if(cur->val == search) {
            Solution::parent.push_back(par);
            return depth; 
        }
        
        int temp1 = dfs(cur->left, depth+1, search, cur->val);
        int temp2 = dfs(cur->right, depth+1, search, cur->val);
        if(temp1 != -1) return temp1; 
        if(temp2 != -1) return temp2; 
        return -1;
    }
};
