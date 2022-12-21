class Solution {
public:
    bool possibleBipartition(int n, vector<vector<int>>& dislikes) {
        // bfs node colors 
        vector<int> colors = vector(n, -1); 

        // form adjlist 
        vector<vector<int>> adjlist = vector(n, vector(0, 0)); 
        for(vector<int>& edge : dislikes) {
            adjlist[edge[0]-1].push_back(edge[1]-1);
            adjlist[edge[1]-1].push_back(edge[0]-1);
        }

        // bfs 
        for(int i = 0; i < n; i++) {
            if(colors[i] == -1 && adjlist[i].size() > 0) { // unvisited and part of graph 
                // bfs with 2 queues 
                queue<int> cur, next; next.push(i); 
                int cur_color = 0; 
                while(!next.empty()) {
                    cur_color = !cur_color; // flip color
                    cur = next;             // switch to next queue 
                    next = queue<int>(); 
                    while(!cur.empty()) {
                        int idx = cur.front(); cur.pop(); 
                        if(colors[idx] == -1) colors[idx] = cur_color;
                        else if(colors[idx] != cur_color) return false; 
                        else continue; // already visited 

                        for(int n : adjlist[idx]) next.push(n); 
                    }
                }
            }
        }

        return true; 
    }
};
