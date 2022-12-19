class Solution {
public:
    bool validPath(int n, vector<vector<int>>& edges, int source, int destination) {

        // assemble adjlist
        vector<vector<int>> adjlist = vector(n, vector(0, 0));
        for(vector<int>& edge : edges) {
            adjlist[edge[0]].push_back(edge[1]);
            adjlist[edge[1]].push_back(edge[0]);
        }

        // bfs 
        vector<int> visited = vector(n, 0); 
        queue<int> next; next.push(source); 

        // bfs 
        while(!next.empty()) {
            int cur = next.front(); next.pop(); 

            if(visited[cur]) continue; 
            visited[cur] = 1; 

            // traverse 
            if(cur == destination) return true; 

            for(int n : adjlist[cur]) next.push(n); 
        }
        return false; 
    }
};
