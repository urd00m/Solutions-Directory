class Solution {
public:
    int minReorder(int n, vector<vector<int>>& connections) {
        // flip all edges that aren't in the reverse direction when traversing the tree
        vector<unordered_set<int>> orig = vector(n, unordered_set<int>());
        vector<vector<int>> bi = vector(n, vector(0, 0)); 
        for(vector<int>& c : connections) {
            orig[c[1]].insert(c[0]); 
            bi[c[0]].push_back(c[1]); 
            bi[c[1]].push_back(c[0]); 
        }

        // run traversal 
        int ret = 0; 
        vector<int> visited = vector(n, 0); 
        queue<int> next; next.push(0); 
        while(!next.empty()) {
            int cur = next.front(); next.pop(); 
            visited[cur] = 1; 

            // check all edges 
            for(int next_node : bi[cur]) {
                if(visited[next_node]) continue; 
                if(orig[cur].find(next_node) == orig[cur].end()) ret++; 
                next.push(next_node); 
            }   
        }
        return ret; 
    }
};
