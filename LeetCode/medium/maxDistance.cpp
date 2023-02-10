class Solution {
public:
    int maxDistance(vector<vector<int>>& grid) {
        if(grid.size() <= 1) return -1; 

        // bfs from multiple sources 
        queue<pair<int,int>> next; 
        vector<vector<int>> dist = vector(grid.size(), vector(grid.size(), INT32_MAX));
        
        // scan 
        bool land = false, water = false; 
        for(int i = 0; i < grid.size(); i++) {
            for(int j = 0; j < grid.size(); j++) {
                if(grid[i][j] == 1) {
                    next.push({i, j}); 
                    dist[i][j] = 0; 
                    land = true; 
                }
                else water = true ;
            }
        }
        if( !(land && water) ) return -1; 

        // begin bfs 
        int ret = 0; 
        vector<vector<int>> visited = vector(grid.size(), vector(grid.size(), 0)); 
        while(!next.empty()) {
            pair<int,int> cur = next.front(); next.pop(); 
            if(visited[cur.first][cur.second]) continue; 
            visited[cur.fi~cl][cur.second] = 1; 
            ret = max(ret, dist[cur.first][cur.second]); 

            // travel in 4 possible directions
            if(cur.first > 0) {
                if(grid[cur.first-1][cur.second] != 1) dist[cur.first-1][cur.second] = min(dist[cur.first-1][cur.second], dist[cur.first][cur.second] + 1); 
                if(!visited[cur.first-1][cur.second]) next.push({cur.first-1, cur.second}); 
            }
            if(cur.first < grid.size()-1) {
                if(grid[cur.first+1][cur.second] != 1) dist[cur.first+1][cur.second] = min(dist[cur.first+1][cur.second], dist[cur.first][cur.second] + 1); 
                if(!visited[cur.first+1][cur.second]) next.push({cur.first+1, cur.second}); 
            }
            if(cur.second > 0) {
                if(grid[cur.first][cur.second-1] != 1) dist[cur.first][cur.second-1] = min(dist[cur.first][cur.second-1], dist[cur.first][cur.second] + 1); 
                if(!visited[cur.first][cur.second-1]) next.push({cur.first, cur.second-1}); 
            }
            if(cur.second < grid.size()-1) {
                if(grid[cur.first][cur.second+1] != 1) dist[cur.first][cur.second+1] = min(dist[cur.first][cur.second+1], dist[cur.first][cur.second] + 1); 
                if(!visited[cur.first][cur.second+1]) next.push({cur.first, cur.second+1}); 
            }
        }
        return ret; 
    }
};
