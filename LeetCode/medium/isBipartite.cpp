class Solution {
public:
    bool isBipartite(vector<vector<int>>& graph) {
        long n = graph.size(); 
        vector<int> color = vector<int>(n, -1);  //0, 1 are colors 
        //bfs 
        queue<int> next; 
        
        for(long i = 0; i < n; i++) {
            if(color[i] == -1) {
                color[i] = 0; 
                next.push(i); 
                while(next.empty() == false) {
                    int cur = next.front(); next.pop(); 
                    for(int j : graph[cur]) {
                        if(color[j] == -1) { //not colored 
                            color[j] = !color[cur];  
                            next.push(j); 
                        }
                        else if(color[j] == color[cur]) return false; 
                    }
                }
            }
        }
        
        return true; // good 
    }
};
