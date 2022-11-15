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
    // 2x and 2x+1

    // determine if the point exists in the tree
    bool mid_exists(TreeNode *root, int height, int idx) {
        TreeNode *cur = root; 
        int len = (int)pow(2, height-1); 
        for(int h = 0; h < height-1; h++) { // bin search down 
            if(idx < len/2)  // left half
                cur = cur->left;
            else { // right half 
                cur = cur->right; 
                idx -= len/2; 
            }
            len /= 2; 
        }

        // last height check position 
        if(cur != nullptr) return true; 
        else return false; 
    }

    int countNodes(TreeNode* root) {
        // scan the left side of the tree to get height
        int height = 0; 
        TreeNode *cur = root;  
        while(cur) { cur = cur->left; height++; }
        if(height == 0) return 0; 

        // do binary search
        int ret = (int)pow(2, height-1) - 1; 
        int l = 0; int r = ret; 
        while(l < r) {
            int mid = (l+r)/2 + 1; 

            // check mid 
            if(mid_exists(root, height, mid)) l = mid; 
            else r = mid - 1; 
        }

        return ret + l + 1; 
    }
};
