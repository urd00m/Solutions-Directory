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
class BSTIterator {
public:
    vector<int> iterator; 
    long idx; 
    BSTIterator(TreeNode* root) {
        dfs(root); 
        idx = 0; 
    }
    
    void dfs(TreeNode* cur) {
        if(cur == nullptr) return; 
        
        dfs(cur->left);
        iterator.push_back(cur->val);
        dfs(cur->right); 
    }
    
    int next() {
        return iterator[idx++]; 
    }
    
    bool hasNext() {
        if(idx < iterator.size()) return true; 
        else return false; 
    }
};

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator* obj = new BSTIterator(root);
 * int param_1 = obj->next();
 * bool param_2 = obj->hasNext();
 */