class Solution {
public:
    // returns number of edges 
    int findComponents(int cur, int& node_count, vector<vector<int>>& adjlist, vector<int>& visited) {
        if(visited[cur]) return 0; 
        visited[cur] = 1; 
        node_count++; 

        // count edges
        int ret = 0; 
        for(int n : adjlist[cur]) {
            if(visited[n]) continue; 
            ret++; 
        }
        for(int n : adjlist[cur]) {
            if(visited[n]) continue; 
            ret += findComponents(n, node_count, adjlist, visited); 
        }
        return ret; 
    }

    int makeConnected(int n, vector<vector<int>>& connections) {
        // simple count disjoint componts + edges to spare if there aren't enough to connect all disjoint components return false, else return number of disjoint components 
        vector<vector<int>> adjlist = vector(n, vector(0, 0)); 
        for(vector<int>& c : connections) {
            adjlist[c[0]].push_back(c[1]);
            adjlist[c[1]].push_back(c[0]);
        }

        // find disjoint components 
        vector<int> visited = vector(n, 0); 
        int te = 0; 
        int nd = 0; 
        for(int i = 0; i < n; i++) {
            if(visited[i] == true) continue; 
            int node_count = 0; 
            te += findComponents(i, node_count, adjlist, visited) - node_count + 1; 
            nd++; 
            // cout << node_count << " " << te << endl; 
        }

        // see if possible 
        if(nd == 1) return 0; 
        else if(nd-1 > te) return -1; 
        else return nd-1; 
    }
};
