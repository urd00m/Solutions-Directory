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
    int pseudoPalindromicPaths (TreeNode* root) {
        // dfs and pass by vector, if there are an even number then each letter needs to be divisible by 2 if it is an odd size then it must be 1 odd number and the rest need to be even. v
        vector<int> charCounter = vector(10, 0);
        int tot = 0; 
        return countPsuedo(root, charCounter, tot); 
    }
    
    int countPsuedo(TreeNode* cur, vector<int> &charCounter, int &tot) {
        if(cur == nullptr) return 0; 
        
        // base case is if we are a leaf node
        if(cur->left == nullptr && cur->right == nullptr) {
            charCounter[cur->val]++; tot++; 
            int odd = 0; int ret = 0; 
            for(int i = 0; i < 10; i++) odd += charCounter[i]%2; 
            if(odd == 1 && tot%2 == 1) ret = 1; 
            else if(odd == 0 && tot%2 == 0) ret = 1; 
            charCounter[cur->val]--; tot--; //don't call children so need to pop 
            return ret;
        } 
        
        // push to stack 
        charCounter[cur->val]++; tot++; 
        int ret = countPsuedo(cur->left, charCounter, tot) + countPsuedo(cur->right, charCounter, tot);
        charCounter[cur->val]--; tot--;
        return ret; 
    }
};
