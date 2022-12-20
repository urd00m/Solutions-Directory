class Solution {
public:
    bool canVisitAllRooms(vector<vector<int>>& rooms) {
        // bfs 
        int n = rooms.size(); 
        int num_visited = 0;
        vector<int> visited = vector(n, 0); 
        queue<int> next; next.push(0); visited[0] = 1; 

        while(!next.empty()) {
            int cur = next.front(); next.pop(); 
            if(++num_visited == n) return true; 

            for(int n : rooms[cur]) 
                if(!visited[n]) {
                    visited[n] = 1;
                    next.push(n); 
                }
        }
        return false; 
    }
};
