class Solution {
public:
    double maxProbability(int n, vector<vector<int>>& edges, vector<double>& succProb, int start, int end) {
        // adj list 
        vector<vector<pair<double,int>>> adjlist = vector(n, vector<pair<double,int>>(0, {0.0, 0})); 
        for(int i = 0; i < succProb.size(); i++) {
            vector<int>& e = edges[i]; 
            adjlist[e[0]].push_back({succProb[i], e[1]});
            adjlist[e[1]].push_back({succProb[i], e[0]});
        }

        // dijkstra's
        vector<int> v = vector(n, 0); 
        vector<double> dist = vector(n, 0.0); 
        dist[start] = 1.0; 
        priority_queue<pair<double,int>, vector<pair<double,int>>, less<pair<double,int>>> pq; pq.push({1.0, start}); 
        while(!pq.empty()) {
            pair<double,int> cur = pq.top(); pq.pop();
            v[cur.second] = 1; 

            // update 
            for(pair<double,int>& n : adjlist[cur.second]) {
                if(v[n.second]) continue; 
                if(dist[n.second] < dist[cur.second] * n.first) {
                    dist[n.second] = dist[cur.second] * n.first;
                    pq.push({dist[n.second], n.second}); 
                }
            }
        }
        return dist[end];
    }
};
