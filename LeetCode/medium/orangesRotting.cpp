class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        size_t n = grid.size(); 
        size_t m = grid[0].size(); 
        
        //preprocess 
        vector<pair<size_t,size_t>> rotten(0); 
        int fresh = 0; 
        for(size_t i = 0; i < n; i++) {
            for(size_t j = 0; j < m; j++) {
                if(grid[i][j] == 2) rotten.push_back(make_pair(i, j));
                else if(grid[i][j] == 1) fresh++;
            }
        }
        
        //iteration 
        int changes = 1;
        int turns = 0;
        while(changes != 0) {
            changes = 0; 
            vector<pair<size_t, size_t>> toAdd(0); 
            for(pair item : rotten) {
                size_t row = item.first; 
                size_t col = item.second; 
                if(row != 0 && grid[row-1][col] == 1) {
                    fresh--; 
                    changes++;
                    grid[row-1][col] = 2; 
                    toAdd.push_back(make_pair(row-1, col));
                }
                if(row+1 < n && grid[row+1][col] == 1) {
                    fresh--; 
                    changes++;
                    grid[row+1][col] = 2; 
                    toAdd.push_back(make_pair(row+1, col));
                }
                if(col != 0 && grid[row][col-1] == 1) {
                    fresh--; 
                    changes++;
                    grid[row][col-1] = 2; 
                    toAdd.push_back(make_pair(row, col-1));
                }
                if(col+1 < m && grid[row][col+1] == 1) {
                    fresh--; 
                    changes++;
                    grid[row][col+1] = 2; 
                    toAdd.push_back(make_pair(row, col+1));
                }
            }
            
            //add in new values 
            for(pair item : toAdd) rotten.push_back(item);
/*
            for(vector<int> ary : grid) {
                for(int item : ary) {
                    cout << item << " ";
                }
                cout << endl; 
            }
            cout << "-------" << endl;
            */
            turns++; 
        }
        
        //return 
        if(fresh != 0) return -1;
        return turns-1;
    }
};
