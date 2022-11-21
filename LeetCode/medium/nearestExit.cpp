class Solution {
public:
    bool exit(vector<vector<char>>& maze, vector<int>& pos) {
        if(pos[0] == 0 || pos[0] == maze.size() - 1) return true; 
        if(pos[1] == 0 || pos[1] == maze[0].size() - 1) return true;
        return false; 
    }

    int nearestExit(vector<vector<char>>& maze, vector<int>& entrance) {
        // bfs to nearest path 
        queue<vector<int>> next; 
        vector<vector<int>> visited = vector(maze.size(), vector(maze[0].size(), 0));
        next.push({entrance[0], entrance[1], 0}); 
        int ret = -1; 
        while(!next.empty()) {
            int dist = next.front()[2]; 
            vector<int> cur = next.front(); next.pop(); 
            
            // bounds check
            if(cur[0] < 0 || cur[0] >= maze.size()) continue; 
            if(cur[1] < 0 || cur[1] >= maze[0].size()) continue; 
            if(maze[cur[0]][cur[1]] == '+') continue; 

            // check visited
            if(visited[cur[0]][cur[1]]) continue; 
            visited[cur[0]][cur[1]] = 1; 

            // if we are an exit
            if(dist != 0 && exit(maze, cur)) {
                ret = dist; 
                break; 
            }

            // visit next ones 
            next.push({cur[0] + 1, cur[1], dist+1});
            next.push({cur[0] - 1, cur[1], dist+1});
            next.push({cur[0], cur[1] + 1, dist+1});
            next.push({cur[0], cur[1] - 1, dist+1});
        }
        return ret; 
    }
};
