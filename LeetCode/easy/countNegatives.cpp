class Solution {
public:
    int countNegatives(vector<vector<int>>& grid) {
        // start on the top right corner 
        // maintain a row counter 
        size_t n = grid.size(); 
        size_t m = grid[0].size(); 
        int r = 0, c = m-1; 
        int rcount = 0; 
        int ret = 0; 
        while(r < n) {
            if(c == -1) {
                ret += (rcount * (n - r));
                break; 
            }

            if(grid[r][c] < 0) {
                c--; 
                rcount++;
            }
            else {
                r++; 
                ret += rcount; 
            }
        }
        return ret; 
    }
};

// 4 3 2 -1
// 3 2 1 -1 
// 1 1 -1 -2 
// -1 -1 -2 -3 
