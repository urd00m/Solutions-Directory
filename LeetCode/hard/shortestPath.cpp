class Solution {
public:  
    int shortestPath(vector<vector<int>>& grid, int k) {
        int height = grid.size(); 
        int width = grid[0].size();
        
        vector<vector<int>> paint(height, vector<int>(width, -1)); 
        queue<vector<int>> q; 
        
        q.push({0, 0, k, 0}); 
        while(q.empty() == false) {
            auto cur = q.front();
            q.pop();
            
            // invalid 
            if(cur[0] < 0 || cur[0] >= height || cur[1] < 0 || cur[1] >= width || (paint[cur[0]][cur[1]] != -1 && paint[cur[0]][cur[1]] >= cur[2])) continue; 
            
            // we have won
            if(cur[0] == height-1 && cur[1] == width-1) {
                return cur[3]; 
            }
            
            // check if we had enough k to move here
            if(grid[cur[0]][cur[1]] == 1) {
                if(cur[2] > 0) {
                    cur[2]--;
                }
                else continue; //not enough this one should be skipped 
            }
            
            //mark this one 
            paint[cur[0]][cur[1]] = cur[2]; 
            
            // Move to next ones
            q.push({cur[0]+1, cur[1], cur[2], cur[3]+1});
            q.push({cur[0]-1, cur[1], cur[2], cur[3]+1});
            q.push({cur[0], cur[1]+1, cur[2], cur[3]+1});
            q.push({cur[0], cur[1]-1, cur[2], cur[3]+1});
        }
        
        return -1;
        
        //interesting optimization, instead of checking before pushing, you should check after you run it, during running
    }
};
