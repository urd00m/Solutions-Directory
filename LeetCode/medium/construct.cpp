/*
// Definition for a QuadTree node.
class Node {
public:
    bool val;
    bool isLeaf;
    Node* topLeft;
    Node* topRight;
    Node* bottomLeft;
    Node* bottomRight;
    
    Node() {
        val = false;
        isLeaf = false;
        topLeft = NULL;
        topRight = NULL;
        bottomLeft = NULL;
        bottomRight = NULL;
    }
    
    Node(bool _val, bool _isLeaf) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = NULL;
        topRight = NULL;
        bottomLeft = NULL;
        bottomRight = NULL;
    }
    
    Node(bool _val, bool _isLeaf, Node* _topLeft, Node* _topRight, Node* _bottomLeft, Node* _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
*/

class Solution {
public:
    Node* recur(int t, int b, int l, int r, vector<vector<int>>& grid) {
        // base case 
        if(t-b == 0) // all should be one
            return new Node(grid[t][l], true, nullptr, nullptr, nullptr, nullptr); 

        // check to see if we are all the same 
        int val = grid[t][l]; 
        bool same = true; 
        for(int i = t; i <= b; i++)
            for(int j = l; j <= r; j++) 
                if(grid[i][j] != val) {
                    same = false; 
                    break; 
                }
        
        // if they are all the same 
        if(same)
            return new Node(val, true, nullptr, nullptr, nullptr, nullptr); 
        
        // else recur 4 corners
        int rowm = (t+b)/2; 
        int colm = (l+r)/2; 
        Node* topleft = recur(t, rowm, l, colm, grid);
        Node* topright = recur(t, rowm, colm+1, r, grid);
        Node* botleft = recur(rowm+1, b, l, colm, grid);
        Node* botright = recur(rowm+1, b, colm+1, r, grid);
        return new Node(1, false, topleft, topright, botleft, botright); 
    }

    Node* construct(vector<vector<int>>& grid) {
        return recur(0, grid.size()-1, 0, grid.size()-1, grid); 
    }
};
