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
    TreeNode* bstFromPreorder(vector<int>& preorder) {
        TreeNode* root = new TreeNode(preorder[0]); 
        stack<TreeNode*> next; stack<bool> leftOrRight;

        //stay on the left 
        TreeNode* top = nullptr; 
        TreeNode* cur = root; 
        
        long i = 1; 
        next.push(nullptr); //mark root as left for the fun of it 
        while(i < preorder.size()) {
            
            cout << "cur " << cur->val << " "; 
            if(top != nullptr) cout << top->val; 
            cout << endl; 
            
            
            //left or right side
            bool leftSideOfRoot = cur->val < root->val; 
            bool leftSideOfSubTree = false; 
            if(top!= nullptr) leftSideOfSubTree = cur->val < top->val; 

            //Go back up
            bool shiftUp = false; 

            if(top != nullptr && leftSideOfRoot && leftSideOfSubTree && preorder[i] > top->val) 
                shiftUp = true;
            if(top != nullptr && !leftSideOfRoot && !leftSideOfSubTree && preorder[i] < top->val)
                shiftUp = true; 
            
            cout << leftSideOfRoot << " " << shiftUp << endl; 
            if(shiftUp) {
                cur = top;
                next.pop();
                top = next.top(); 
                leftOrRight.pop(); 
            }
            else if(preorder[i] < cur->val) { //go left 
                if(cur->left == nullptr) { //create new index 
                    cur->left = new TreeNode(preorder[i]); 
                    i++; 
                }
                top = cur; //shift it to that new index 
                cur = cur->left;
                next.push(top); 
            } else if(preorder[i] > cur->val) { //go right
                if(cur->right == nullptr) { //create new index 
                    cur->right = new TreeNode(preorder[i]); 
                    i++; 
                }
                top = cur; //shift it to that new index 
                cur = cur->right;
                next.push(top); 
            } else {
                //something went wrong
                cout << "error" << endl; 
            }
        }
        return root; 
    }
};

//fails for 4,10,7,9,11
