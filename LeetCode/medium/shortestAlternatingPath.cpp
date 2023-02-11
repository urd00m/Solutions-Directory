#define RED 0
#define BLUE 1

class Solution {
public:
    vector<int> shortestAlternatingPaths(int n, vector<vector<int>>& redEdges, vector<vector<int>>& blueEdges) {
        // bfs 
        vector<vector<int>> visited = vector(n, vector(2, 0));  // N x 2 for blue and red side 

        // create adjlist 
        vector<vector<int>> adjr = vector(n, vector(0, 0)); 
        vector<vector<int>> adjb = vector(n, vector(0, 0)); 
        for(vector<int>& e : redEdges) adjr[e[0]].push_back(e[1]);
        for(vector<int>& e : blueEdges) adjb[e[0]].push_back(e[1]);

        // begin bfs 
        queue<vector<int>> next; // {next node, distance, edge} 
        vector<vector<int>> dist = vector(n, vector(2, INT32_MAX));     
        dist[0][RED] = 0; 
        dist[0][BLUE] = 0;
        next.push({0, 0, RED});
        next.push({0, 0, BLUE});
        while(!next.empty()) {
            vector<int> cur = next.front(); next.pop(); 

            // already visited 
            if(visited[cur[0]][cur[2]]) continue; 
            visited[cur[0]][cur[2]] = 1; // mark visited 

            // mark neighbors 
            if(cur[2] == RED) {
                for(int nn : adjb[cur[0]]) {
                    if(dist[cur[0]][RED] + 1 < dist[nn][BLUE]) {
                        next.push({nn, cur[1]+1, BLUE}); 
                        dist[nn][BLUE] = cur[1]+1; 
                    }
                }
            } else { // is BLUE
                for(int nn : adjr[cur[0]]) {
                    if(dist[cur[0]][BLUE] + 1 < dist[nn][RED]) {
                        next.push({nn, cur[1]+1, RED}); 
                        dist[nn][RED] = cur[1]+1; 
                    }
                }
            }
        }

        // find max of both 
        vector<int> ret = vector(n, 0); 
        for(int i = 0; i < n; i++) {
            ret[i] = min(dist[i][RED], dist[i][BLUE]);
            if(ret[i] == INT32_MAX) ret[i] = -1; 
        }
        return ret; 
    }
};
